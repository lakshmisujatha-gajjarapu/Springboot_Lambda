package com.test.lambda.actions;

import java.util.ArrayList;

import com.test.lambda.model.IntervalObject;

public class IntervalAppender {

	public static String append(ArrayList<com.test.lambda.model.IntervalObject> splitInterval) {
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder();
		for( com.test.lambda.model.IntervalObject intervalObject : splitInterval){
			stringBuilder.append(intervalObject.getIntervalStart() + "-" + intervalObject.getIntervalEnd() + ",");
		}
		
		String resultInterval = (stringBuilder.toString().substring(0, stringBuilder.toString().length()-1));
		return resultInterval;
	}
	
}
