package com.holddie.springboot.freemarker.utils;

import com.holddie.springboot.freemarker.component.tag.StringSubTag;
import freemarker.template.Configuration;

import java.io.StringWriter;
import java.util.Map;

public class FreemarkerUtil {
    public static final Configuration cfg = new Configuration();
    static {
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
        cfg.setNumberFormat("###########.##");
        cfg.setSharedVariable("StringSubTag", new StringSubTag());
    }

    public static String process(String template, Map<String, ?> model) throws Exception {
        StringWriter out = new StringWriter();
        String result = null;
        try {
            FreemarkerUtil.cfg.getTemplate(template + ".ftl").process(model, out);
            result = out.toString();
        } catch (Exception ex) {
            throw ex;
        } finally {
            out.close();
        }
        return result;
    }
}