package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;

public interface IndexWorker {
	
	void init(SearchClient client);
	void execute(SearchClient client, String json, String index, String type, Long id) throws Exception;

}
