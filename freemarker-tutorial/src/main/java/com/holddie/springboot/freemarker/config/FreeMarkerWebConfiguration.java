package com.holddie.springboot.freemarker.config;

import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.*;

@Configuration
public class FreeMarkerWebConfiguration {
	
	@Autowired
	private FreeMarkerProperties properties;
	
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer() throws TemplateModelException {
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		applyProperties(configurer);
		applyVariables(configurer);
		configurer.setPreferFileSystemAccess(false);
		return configurer;
	}
	
	/**
	 * applyVariables(这里用一句话描述这个方法的作用)
	 *
	 * @Title: applyVariables
	 * @Description: 
	 * @param configurer  void    返回类型
	 * @throws
	 * @author JeremyWang
	 * @date 2015年9月10日 下午4:50:04
	 * 
	 */
	private void applyVariables(FreeMarkerConfigurer configurer) {
		Map<String, Object> variables = new HashMap<>();
		variables.put("levelmeth", (TemplateMethodModelEx) args -> {
            if(args.size() != 1){
                throw new TemplateModelException("Wrong arguments");
            }
            return args.get(0).toString().substring(0,3);
        });
		configurer.setFreemarkerVariables(variables);
		List<TemplateLoader> postTemplateLoaders = createCustomTemplateLoaders();
		configurer.setPostTemplateLoaders(postTemplateLoaders.toArray(new TemplateLoader[0]));
	}

	private List<TemplateLoader> createCustomTemplateLoaders() {
		List<TemplateLoader> temlateLoaders = new ArrayList<>();
		if (properties.getTemplateLoaderPath() != null) {
			for (String path : properties.getTemplateLoaderPath()) {
				temlateLoaders.add(new SpringTemplateLoader(new ClassRelativeResourceLoader(this.getClass()) , path));
			}
		}
		return temlateLoaders;
	}

	private void applyProperties(FreeMarkerConfigurationFactory factory) {
		factory.setTemplateLoaderPaths(this.properties.getTemplateLoaderPath());
		factory.setDefaultEncoding(String.valueOf(this.properties.getCharset()));
		Properties settings = new Properties();
		settings.putAll(this.properties.getSettings());
		factory.setFreemarkerSettings(settings);
	}

}