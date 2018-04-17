package com.holddie.springboot.elasticsearch.tutorial.search.services.workflow;


import com.holddie.springboot.elasticsearch.tutorial.search.services.RZGetResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class GetWorkflow extends Workflow {
	
	@Autowired
	private SearchDelegate searchDelegate;
	public RZGetResponse getObject(String index, String type, String id) throws Exception {

		return searchDelegate.getObject(index, type, id);
		
	}

}
