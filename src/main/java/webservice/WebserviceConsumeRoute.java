package webservice;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class WebserviceConsumeRoute extends RouteBuilder{
	org.apache.camel.component.http.HttpComponent c;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:getdata").setHeader(Exchange.HTTP_METHOD, simple("GET"))
		.to("http://localhost:8081/testemployee").process(
				new Processor(){

					@Override
					public void process(Exchange arg) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("processing get request");
						System.out.println(arg.getIn().getBody(String.class));
						
					}
					
					
				});

	}

}
