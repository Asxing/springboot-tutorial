package com.holddie.wardeploy.component.tag;

import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LevelMethod implements TemplateMethodModelEx {
    @Override
    public Object exec(List args) throws TemplateModelException {
        if(args.size() != 1){
            throw new TemplateModelException("Wrong arguments");
        }
        return args.get(0).toString().substring(0,3);
    }
}