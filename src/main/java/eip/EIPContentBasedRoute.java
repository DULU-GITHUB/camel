package eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class EIPContentBasedRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		/*from("file:C:\\Users\\Manoranjan Gharai\\workspace\\camel\\src\\main\\resources\\inFolder\\content?noop=true").split().tokenize("\n").to("direct:test");
        
		//Content Based routing- Route the message based on the token it contains.
		        from("direct:test"). 
		        choice().
		        when(body().contains("eip1"))
		        .to("jms:queue:eip1?connectionFactory=connectionFactory").
		        when(body().contains("eip2"))
		        .to("jms:queue:eip2?connectionFactory=connectionFactory")
		        .when(body().contains("eip3"))
		        .to("jms:queue:eip3?connectionFactory=connectionFactory").
		        otherwise().
		        to("jms:queue:eip?connectionFactory=connectionFactory");*/
		
	}

}
