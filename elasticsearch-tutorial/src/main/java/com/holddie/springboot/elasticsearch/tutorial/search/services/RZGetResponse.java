package com.holddie.springboot.elasticsearch.tutorial.search.services;

import com.holddie.springboot.elasticsearch.tutorial.common.jsontool.JsonMapper;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.index.get.GetField;

import java.util.List;
import java.util.Map;

public class RZGetResponse {

	private GetResponse response;

	public RZGetResponse(GetResponse r) {
		response = r;
	}

	public String getResponseAsString() {
		return JsonMapper.toJsonString(this.getFields());
	}

	public Map<String, Object> getFields() {
		return response.getSource();
	}

	public List<Object> getField(String key) {
		GetField f = response.getFields().get(key);
		if (f != null) {
			return f.getValues();
		}
		return null;
	}

}
