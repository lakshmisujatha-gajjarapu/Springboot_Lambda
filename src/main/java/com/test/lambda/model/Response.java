package com.test.lambda.model;

import java.util.Map;
//import com.amazonaws.services.*;

import groovy.transform.ToString;
import groovy.transform.builder.Builder;

@Builder
@ToString(includePackage = false)
public class Response {
	int statuscode;
	
	private String includeIntervals;
	private String excludeIntervals;
	private String result;
	
//	private Map<String, String> headers = [:] ;
//	
//	void addHeader(String key, String value) 
//	{
//		headers.put(key, value);
//	}
//	

}
