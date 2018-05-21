package com.holddie.springboot.mybatis.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2配置文件
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/18 18:31
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.holddie.springboot.rest.controller"))
                .paths(PathSelectors.ant("/rest/**"))
                .build();
    }

    @Bean
    public Docket createRestyApi() {
        return new Docket(DocumentationType.SWAGGER_2)

                .groupName("rest分组").apiInfo(apiInfo()).select()

                .paths(PathSelectors.ant("/user/**")).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("HoldDie Document by Swagger2")
                .description("好香~")
                .termsOfServiceUrl("https://www.holddie.com")
                .version("1.0.0")
                .build();
    }

}
