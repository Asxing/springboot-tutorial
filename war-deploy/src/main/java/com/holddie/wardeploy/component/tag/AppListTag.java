package com.holddie.wardeploy.component.tag;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/12 16:07
 */
@Component
public class AppListTag implements TemplateMethodModelEx {

    @SuppressWarnings("rawtypes")
    @Override
    public Object exec(List arguments) throws TemplateModelException {
        StringBuilder ret = new StringBuilder("DictItemTag");
        if (CollectionUtils.isNotEmpty(arguments)) {
            for (Object obj : arguments) {
                ret.append("-").append(obj);
            }
        }
        return ret.toString();
    }
}
