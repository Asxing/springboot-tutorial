package com.holddie.springboot.elasticsearch.tutorial.search.services.delegate;

import com.holddie.springboot.elasticsearch.tutorial.search.services.RZGetResponse;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZIndexKeywordRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchRequest;
import com.holddie.springboot.elasticsearch.tutorial.search.services.RZSearchResponse;

import java.util.Collection;
import java.util.Set;


public interface SearchDelegate {

	boolean indexExist(String indexName) throws Exception;
	
	boolean typeExist(String index, String type) throws Exception;

	void createIndice(String mappingJson, String settingsJson, String indice, String type) throws Exception;

    void createType(String mappingJson, String settingsJson, String indice, String type) throws Exception;

	void index(String json, String index, String type, String id);

	void delete(String index, String type, String id) throws Exception;

	void bulkDeleteIndex(String index, String type, Collection<String> ids) throws Exception;

	void bulkIndexKeywords(Collection<RZIndexKeywordRequest> bulks, String index, String type) throws Exception;

	RZGetResponse getObject(String index, String type, String id) throws Exception;

	RZSearchResponse search(RZSearchRequest request) throws Exception;

	Set<String> searchAutoComplete(String index, String json, String type, int size) throws Exception;

}