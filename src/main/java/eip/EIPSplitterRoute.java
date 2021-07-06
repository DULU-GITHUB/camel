package eip;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class EIPSplitterRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		 //from("file:C:\\Users\\Manoranjan Gharai\\workspace\\camel\\src\\main\\resources\\inFolder\\splitter?noop=true").split().tokenize("\n").to("jms:queue:eip?connectionFactory=connectionFactory");
		
	}

}
