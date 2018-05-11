package com.holddie.springboot.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试freemarker
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/5/11 21:34
 */
@Controller
@RequestMapping("/")
public class TestController {


    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("name", "holddie");
        return "test";
    }
}
