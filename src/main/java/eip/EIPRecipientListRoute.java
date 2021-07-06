package eip;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class EIPRecipientListRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("file:C:\\Users\\Manoranjan Gharai\\workspace\\camel\\src\\main\\resources\\inFolder\\recipient?noop=true").split().tokenize("\n").to("direct:test");
        
		//Recipient List- Dynamically set the recipients of the exchange 
		         //by creating the queue name at runtime
		        from("direct:test")
		        .process(new Processor() {
		            public void process(Exchange exchange) throws Exception {
		               String recipient = exchange.getIn().getBody().toString();
		               String recipientQueue="jms:queue:"+recipient;
		               exchange.getIn().setHeader("queue", recipientQueue);
		      }
		      }).recipientList(header("queue"));
		
	}

}
