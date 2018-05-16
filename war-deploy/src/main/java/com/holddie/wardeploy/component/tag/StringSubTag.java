package com.holddie.wardeploy.component.tag;

import freemarker.template.SimpleNumber;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 截取显示字符串，当字符串长度超过指定长度时，显示截取部分加...
 * @author HoldDie
 * @version v1.0.0
 * @email HoldDie@163.com
 * @date 2018/5/12 16:33
 */
@Component
public class StringSubTag implements TemplateMethodModelEx {

    @Override
    public Object exec(@SuppressWarnings("rawtypes") List args) throws TemplateModelException {
        if (args == null || args.size() < 2) {
            throw new RuntimeException("missing arg");
        }

        if (args.get(0) == null || args.get(1) == null) {
            return "";
        }

        SimpleScalar simpleScalar = (SimpleScalar) args.get(0);
        String content = simpleScalar.getAsString();
        SimpleNumber simpleNumber = (SimpleNumber) args.get(1);
        Integer length = simpleNumber.getAsNumber().intValue();

        if (content.length() > length) {
            content = content.substring(0, length);
            return content + "...";
        }

        return content;
    }

}
