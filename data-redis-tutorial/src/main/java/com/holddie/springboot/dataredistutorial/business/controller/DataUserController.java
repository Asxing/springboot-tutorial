package com.holddie.springboot.dataredistutorial.business.controller;

import com.holddie.springboot.dataredistutorial.business.entity.DataUserEntity;
import com.holddie.springboot.dataredistutorial.business.service.DataUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/7/31 10:35
 */
@RestController
@RequestMapping(value = "user")
@Slf4j
public class DataUserController {

    @Autowired
    private DataUserService dataUserService;

    @GetMapping(value = "findall")
    @Cacheable(value = "find:all")
    public List<DataUserEntity> dataUser() {
        return dataUserService.findAll();
    }

}
