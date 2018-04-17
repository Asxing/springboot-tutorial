package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchWorkerImpl implements SearchWorker {

	@Autowired
	private SearchDelegate searchDelegate;

    @Override
	public RZSearchResponse execute(SearchClient client, RZSearchRequest request) throws Exception {
		RZSearchResponse response = searchDelegate.search(request);
		response.setInputSearchJson(request.getJson());
		return response;

	}

}
