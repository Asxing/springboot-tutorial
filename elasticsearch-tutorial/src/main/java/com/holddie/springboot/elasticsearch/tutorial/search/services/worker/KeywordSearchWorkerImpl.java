package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;


public class KeywordSearchWorkerImpl implements KeywordSearchWorker {

	@Autowired
	private SearchDelegate searchDelegate;

	@Override
	public RZSearchResponse execute(SearchClient client, String index,
                                    String json, String type, int size) throws Exception {

		Collection<String> hits = searchDelegate.searchAutoComplete(index,
				json, type, size);
		RZSearchResponse resp = new RZSearchResponse();

		String[] array = (String[]) hits.toArray(new String[hits.size()]);

		resp.setInlineSearchList(array);
		if (array.length > 0) {
			resp.setCount(array.length);
		}

		return resp;

	}

}
