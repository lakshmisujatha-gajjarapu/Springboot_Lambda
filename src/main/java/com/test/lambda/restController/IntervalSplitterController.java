package com.test.lambda.restController;

import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import com.test.lambda.core.MainBusiness;
import com.test.lambda.model.IntervalSplitter;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IntervalSplitterController implements ErrorController{
	
	@GetMapping("/intervalSplitter/inputInterval/{includeInterval}/{excludeInterval}")
	public IntervalSplitter intervalSplitterForm(@PathVariable String includeInterval, @PathVariable String excludeInterval){
		
		IntervalSplitter intervalSplitter = new IntervalSplitter();
		intervalSplitter.setIncludeIntervals(includeInterval);
    	intervalSplitter.setExcludeIntervals(excludeInterval);
		String result = MainBusiness.splitInputInterval(includeInterval, excludeInterval);
		intervalSplitter.setResult(result);
		//putText(result);
		
		return intervalSplitter;
	}
	
	private void putText(String result) {
		// TODO Auto-generated method stub
		
	}

	@RequestMapping(value = "intervalSplitter/inputInterval/{includeInterval}/{excludeInterval}", path = "intervalSplitter/inputInterval/{includeInterval}/{excludeInterval}")
	@PostMapping("/intervalSplitter/inputInterval/{includeInterval}/{excludeInterval}")
	public String intervalSplitterSubmit(@PathVariable String includeInterval, @PathVariable String excludeInterval){
		
		
//		Response.builder()
//        .statusCode(200)
//        .body(JsonOutput.prettyPrint(JsonOutput.toJson(customers)))
//        .build()
		
		if(includeInterval.trim().isEmpty() || includeInterval == null){
			return "<?xml version=\"1.0\"?>" + "<intervalSplitter> inputInterval is empty" + "</intervalSplitter>";
		}
		
		String result = MainBusiness.splitInputInterval(includeInterval, excludeInterval);
		IntervalSplitter intervalSplitter = new IntervalSplitter();
		intervalSplitter.setIncludeIntervals(includeInterval);
		intervalSplitter.setExcludeIntervals(excludeInterval);
		intervalSplitter.setResult(result);
		if (result == null || result == "exception" || result == "error") {
			
			return "<?xml version=\"1.0\"?>" + "<intervalSplitter> error in identifying result" + "</intervalSplitter>";
		}
		return "<?xml version=\"1.0\"?>" + "<intervalSplitter> ResultInterval is" + intervalSplitter.getResult() + "</intervalSplitter>";
	}
	 
			
	/* Handling Whitelabel Spring boot error */
	@RequestMapping(value = "/error")
	@PostMapping("/error")
	public String errorHtml(Model model){
		return "/intervalSplitter/inputInterval/{includeInterval}/{excludeInterval}";
	} 
			
	@Override
	public String getErrorPath() {
	return "/error" ;
	} 

}
