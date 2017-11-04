package com.test.lambda.restController;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.test.lambda.core.*;
import com.test.lambda.model.*;


@Path("intervalSplitter")
public class IntervalSplitterResource {


	public IntervalSplitterResource() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
  
    
    @GET
    @Consumes("text/plain")
    @Produces("MediaType.TEXT_XML")
    @Path("inputInterval/{includeInterval}/{excludeInterval}")

    public String intervalSplitterSubmit(@PathParam("includeInterval") String includeInterval, @PathParam("excludeInterval") String excludeInterval){
    if(includeInterval.trim().isEmpty() || includeInterval == null){
		return "<?xml version=\"1.0\"?>" + "<intervalSplitter> inputInterval is empty" + "</intervalSplitter>";
	}
	
	String result = MainBusiness.splitInputInterval(includeInterval, excludeInterval);
	IntervalSplitter intervalSplitter = new IntervalSplitter();
	intervalSplitter.setResult(result);
	putText(result);
	//if (result == null || result == "exception" || result == "error") {
		//return "error";
	//return "<?xml version=\"1.0\"?>" + "<intervalSplitter> error in result" + "</intervalSplitter>";
	//}
	return "<?xml version=\"1.0\"?>" + "<intervalSplitter> ResultInterval is" + intervalSplitter.getResult() + "</intervalSplitter>";
   }
    
    
    
    @PUT
    @Consumes("text/plain")
    public void putText(String content) {
    
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML})
    public IntervalSplitter getXML(@PathParam("includeInterval") String includeInterval, @PathParam("excludeInterval") String excludeInterval) {
    	IntervalSplitter intervalSplitter = new IntervalSplitter();
    	
    	String result = MainBusiness.splitInputInterval(includeInterval, excludeInterval);
    	intervalSplitter.setIncludeIntervals(includeInterval);
    	intervalSplitter.setExcludeIntervals(excludeInterval);
    	intervalSplitter.setResult(result);
    	return intervalSplitter;
        }
    
}    
