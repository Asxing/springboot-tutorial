package com.holddie.springboot.elasticsearch.tutorial.search.services.worker;


import com.holddie.springboot.elasticsearch.tutorial.search.utils.SearchClient;

/**
 * Deletes an object from the index
 * @author Carl Samson
 *
 */
public interface DeleteObjectWorker {
	
	public void deleteObject(SearchClient client, String index, String type, Long id) throws Exception;

}
