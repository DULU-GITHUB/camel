package configuration;

import javax.jms.ConnectionFactory;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import marshallunmarshall.Student;
import sql.Employee;

@Configuration
public class ApplicationConfiguration {

	@Value(value = "${spring.activemq.broker-url}")
	public String mqUrl;

	@Bean
	public ConnectionFactory connectionFactory() {
		return new ActiveMQConnectionFactory(mqUrl);
	}

	@Bean
	public JaxbDataFormat studentXmlDataFormat() throws JAXBException {
		JaxbDataFormat xmlDataFormat = new JaxbDataFormat();
		JAXBContext con = JAXBContext.newInstance(Student.class);
		xmlDataFormat.setContext(con);
		return xmlDataFormat; 
	}
	
	@Bean
	public JacksonDataFormat studentJsonDataFormat() 
	{
	JacksonDataFormat jsonDataFormat = new JacksonDataFormat(Employee.class);
	return jsonDataFormat; 
	}

}
