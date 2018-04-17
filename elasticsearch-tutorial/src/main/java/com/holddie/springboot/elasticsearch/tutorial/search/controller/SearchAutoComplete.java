package com.holddie.springboot.elasticsearch.tutorial.search.controller;

import com.holddie.springboot.elasticsearch.tutorial.search.SearchKeywords;
import com.holddie.springboot.elasticsearch.tutorial.search.service.GoodsSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangze1
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/4/17 16:32
 */
@RestController
@RequestMapping(value = "/search")
public class SearchAutoComplete {

    @Autowired
    private GoodsSearch goodsSearch;

    @GetMapping(value = "autoComplete")
    public SearchKeywords searchAutoComplete(String index, String type, String keyword, int entriesCount){
        return goodsSearch.searchAutoComplete(index, type, keyword,entriesCount);
    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String test(){
        System.out.println("123");
        return "123123";
    }
}
