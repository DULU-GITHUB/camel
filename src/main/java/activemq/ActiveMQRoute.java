package activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.properties.PropertiesComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class ActiveMQRoute extends RouteBuilder {

	/*
	 * @Bean public ConnectionFactory connectionFactory() { return new
	 * ActiveMQConnectionFactory("tcp://localhost:61616"); }
	 */

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		from("{{route1}}").split().tokenize("\n").doTry().to("{{route2}}?connectionFactory=connectionFactory")
				.doCatch(Exception.class).process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("handling ex");
						final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
						System.out.println(ex);
					}
				});
	}

}
