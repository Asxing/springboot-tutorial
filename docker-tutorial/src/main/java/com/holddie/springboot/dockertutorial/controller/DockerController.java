package com.holddie.springboot.dockertutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Docker测试Controller
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/6 12:06
 */
@RestController
@RequestMapping
public class DockerController {

    @RequestMapping(value = "test")
    public Object dockerTest() {
        Map<String, String> map = new HashMap<>(16);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");
        map.put("4", "4");
        map.put("5", "5");
        return map;
    }

}
