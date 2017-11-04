package com.test.lambda.actions;

import java.util.ArrayList;

import com.test.lambda.model.IntervalObject;
import com.test.lambda.model.IntervalOverlapPoint;

public class IntervalExclude {
	
	public static ArrayList<com.test.lambda.model.IntervalObject> removeExcludes(ArrayList<com.test.lambda.model.IntervalOverlapPoint> intervalOverlapPoint) {
		ArrayList<com.test.lambda.model.IntervalObject> result = new ArrayList<>();

		int one = 1;
		boolean start = false; 
		boolean split = false; 
		int intervalStart = 0;
		for (com.test.lambda.model.IntervalOverlapPoint point : intervalOverlapPoint) {
			switch (point.overlapmode) {
			case IncludeIntervalStart:
				if (!split) {
					intervalStart = point.value;

				}
				start = true;
				break;
			case IncludeIntervalEnd:
				if (!split) {
					result.add(new com.test.lambda.model.IntervalObject(intervalStart, point.value));

				}
				start = false;
				break;
			case ExcludeIntervalStart:
				if (start) {
					if (intervalStart < point.value) {
						result.add(new com.test.lambda.model.IntervalObject(intervalStart, point.value - one));
					}
				}
				split = true;
				break;
			case ExcludeIntervalEnd:
				if (start) {
					intervalStart = point.value + one;

				}
				split = false;
				break;
			}
		}

		return result;
	}



}
