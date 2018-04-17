package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;

public interface KeywordSearchWorker {
	
	RZSearchResponse execute(SearchClient client, String index, String json, String type, int size) throws Exception;

}
