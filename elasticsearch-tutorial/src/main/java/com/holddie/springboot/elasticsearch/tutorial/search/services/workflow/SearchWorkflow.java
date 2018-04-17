package com.holddie.springboot.elasticsearch.tutorial.search.services.workflow;




import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.worker.KeywordSearchWorker;
import com.holddie.springboot.elasticsearch.tutorial.search.services.worker.SearchWorker;

import java.util.List;

public class SearchWorkflow extends Workflow {

	private List<SearchWorker> searchFlow;
	private List<KeywordSearchWorker> searchKeywordWorkflow;

	public List<KeywordSearchWorker> getSearchKeywordWorkflow() {
		return searchKeywordWorkflow;
	}

	public void setSearchKeywordWorkflow(List<KeywordSearchWorker> searchKeywordWorkflow) {
		this.searchKeywordWorkflow = searchKeywordWorkflow;
	}
	
	public List<SearchWorker> getSearchFlow() {
		return searchFlow;
	}

	public void setSearchFlow(List<SearchWorker> searchFlow) {
		this.searchFlow = searchFlow;
	}

	public RZSearchResponse searchAutoComplete(String index, String json, String type,
                                               int size) throws Exception {
		RZSearchResponse response = null;
		if (searchKeywordWorkflow != null) {
//            String keywordType = SearchConstants.KEYWORD + "_" + type;
			for (KeywordSearchWorker sw : searchKeywordWorkflow) {
				response = sw.execute(super.getSearchClient(), index, json,
                        type, size);
			}
		}
		return response;
	}

	public RZSearchResponse search(RZSearchRequest request) throws Exception {
		RZSearchResponse response = null;
		if (searchFlow != null) {
			for (SearchWorker sw : searchFlow) {
				response = sw.execute(super.getSearchClient(), request);
			}
		}
		return response;
	}
}
