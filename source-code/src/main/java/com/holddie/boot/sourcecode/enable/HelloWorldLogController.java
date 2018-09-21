package com.holddie.boot.sourcecode.enable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/8/24 14:06
 */
@RequestMapping("/")
@Controller
public class HelloWorldLogController {

    @Autowired
    private MyLogService myLogService;


    @RequestMapping
    @ResponseBody
    public String helloWorld() {
        myLogService.logStart("hello world!!!");
        return myLogService.logEnd("log end!!!");
    }
}


