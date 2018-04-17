package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.SearchConstants;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.delegate.SearchDelegate;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.CustomIndexConfiguration;
import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;


public class DeleteKeywordsImpl implements DeleteObjectWorker {

	private List<CustomIndexConfiguration> indexConfigurations = null;
	
	public List<CustomIndexConfiguration> getIndexConfigurations() {
		return indexConfigurations;
	}

	public void setIndexConfigurations(
			List<CustomIndexConfiguration> indexConfigurations) {
		this.indexConfigurations = indexConfigurations;
	}

	@Autowired
	private SearchDelegate searchDelegate;

	@Override
	public void deleteObject(SearchClient client, String index, String type, Long id) throws Exception {
		String keywordType = SearchConstants.KEYWORD + "_" + type;
		if (searchDelegate.indexExist(index)) {
			String query = new StringBuilder()
					.append("{\"query\":{\"term\" : {\"dbid\" : \"").append(id)
					.append("\" }}}").toString();
			RZSearchRequest sr = new RZSearchRequest();
			sr.setIndex(index);
			sr.setType(keywordType);
			sr.setJson(query);
			RZSearchResponse r = searchDelegate.search(sr);
			if (r != null) {
				Collection<String> ids = r.getIds();
				searchDelegate.bulkDeleteIndex(index, keywordType, ids);
			}
		}
	}

}
