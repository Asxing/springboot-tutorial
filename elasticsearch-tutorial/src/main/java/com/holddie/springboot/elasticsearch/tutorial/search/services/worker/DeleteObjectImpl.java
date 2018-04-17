package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;

import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;


public class DeleteObjectImpl implements DeleteObjectWorker {

	@Autowired
	private SearchDelegate searchDelegate;

	@Override
	public void deleteObject(SearchClient client, String index,
                             String type, Long id) throws Exception {
		searchDelegate.delete(index, type, id.toString());
	}

}
