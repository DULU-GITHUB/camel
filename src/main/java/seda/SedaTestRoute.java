package seda;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class SedaTestRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("direct:testSeda").to("seda:doProcess").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				for (int i = 0; i < 4; i++) {
					System.out.println("1 : " + i);
					Thread.sleep(2000);
				}

			}
		});
		;

		from("seda:doProcess").process(new Processor() {

			@Override
			public void process(Exchange exchange) throws Exception {
				// TODO Auto-generated method stub
				for (int i = 0; i < 4; i++) {
					System.out.println("2 : " + i);
					Thread.sleep(2000);
				}

			}
		});

	}

}
