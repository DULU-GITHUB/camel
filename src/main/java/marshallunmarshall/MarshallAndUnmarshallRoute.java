package marshallunmarshall;

import javax.jms.ConnectionFactory;
import javax.xml.bind.JAXBContext;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import sql.Employee;

@Service
@Configuration
public class MarshallAndUnmarshallRoute extends RouteBuilder {
	
	/*@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory("tcp://localhost:61616");
	}*/
	
	@Autowired
	JaxbDataFormat studentXmlDataFormat;
	
	@Autowired
	JacksonDataFormat studentJsonDataFormat;

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		// XML Data Format
		/*JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Student.class);
		xmlDataFormat.setContext(con);*/
		
		
		// JSON Data Format
		/*JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);*/

		from("file:C:\\Users\\Manoranjan Gharai\\workspace\\camel\\src\\main\\resources\\inFolder?noop=true").process(new StudentProcessor()).doTry().process(new StudentProcessor()).unmarshal(studentXmlDataFormat).process(new StudentProcessor())
				.marshal(studentJsonDataFormat).to("jms:queue:marshall_unmarshall?connectionFactory=connectionFactory").doCatch(Exception.class).process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("check1");
						Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
						System.out.println(cause);
					}
				});
	}

}
