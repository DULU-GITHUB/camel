package eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class EIPFilterRoute extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		/* from("file:C:\\Users\\Manoranjan Gharai\\workspace\\camel\\src\\main\\resources\\inFolder\\filter?noop=true").split().tokenize("\n").to("direct:test");
	        
	        //Message Filter is a type of Content Based routing. 
	        //If condition satisfied perform a task else discard it.
	        from("direct:test"). 
	        filter(body().contains("eip"))
	        .to("jms:queue:eip?connectionFactory=connectionFactory");*/
		
	}

}
