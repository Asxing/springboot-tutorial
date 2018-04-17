package com.holddie.springboot.elasticsearch.tutorial.search.utils;

import org.springframework.beans.factory.annotation.Value;

public class CustomIndexFieldConfiguration {

	private String fieldName;
	private String fieldType;

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

}
