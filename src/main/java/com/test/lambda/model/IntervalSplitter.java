package com.test.lambda.model;

import javax.xml.bind.annotation.XmlRootElement;

//import com.amazonaws.services.*;
@XmlRootElement
public class IntervalSplitter {

	private String includeIntervals;
	private String excludeIntervals;
	private String result;
//	private final Context context;
	
	public String getIncludeIntervals() {
		return includeIntervals;
	}
	public void setIncludeIntervals(String includeInterval) {
		this.includeIntervals = includeInterval;
	}
	public String getExcludeIntervals() {
		return excludeIntervals;
	}
	public void setExcludeIntervals(String excludeInterval) {
		this.excludeIntervals = excludeInterval;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "Interval [includeIntervals=" + includeIntervals + ", excludeIntervals=" + excludeIntervals + ", result="
				+ result + "]";
	}
	
	
}
