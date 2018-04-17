package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;

public interface SearchWorker {
	
	RZSearchResponse execute(SearchClient client, RZSearchRequest request) throws Exception;

}
