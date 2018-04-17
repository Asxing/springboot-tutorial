package com.holddie.springboot.elasticsearch.tutorial.search;

import java.io.Serializable;
import java.util.List;

public class SearchKeywords  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<String> keywords;

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public List<String> getKeywords() {
		return keywords;
	}

}
