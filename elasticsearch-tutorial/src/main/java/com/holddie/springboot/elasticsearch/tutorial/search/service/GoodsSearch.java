package com.holddie.springboot.elasticsearch.tutorial.search.service;


import com.holddie.springboot.elasticsearch.tutorial.search.SearchKeywords;
import com.holddie.springboot.elasticsearch.tutorial.search.SearchResult;
import com.holddie.springboot.elasticsearch.tutorial.search.model.IndexGoods;

public interface GoodsSearch {

    void importFromDB(String sql) throws Exception;

    void importKeywordFromDB(String sql) throws Exception;

    void createIndex(IndexGoods goods);

    void deleteIndex(Long id);

    SearchKeywords searchAutoComplete(String index, String type, String keyword, int entriesCount);

    SearchResult search(String jsonString, int startIndex, int entriesCount);
}
