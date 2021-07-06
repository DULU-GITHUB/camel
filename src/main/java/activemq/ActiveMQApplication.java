package activemq;

import javax.jms.ConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.properties.PropertiesComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("activemq,configuration")
public class ActiveMQApplication {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = SpringApplication.run(ActiveMQApplication.class, args);
		ProducerTemplate pr = ctx.getBean(ProducerTemplate.class);
		
		
		//CamelContext camel=ctx.getBean(CamelContext.class);
		//PropertiesComponent pc = new PropertiesComponent();
		//pc.setLocation("classpath:camel.properties");
		//camel.addComponent("properties", pc);
		
		
		System.out.println("connection factory 1234: " + ctx.getBean(ConnectionFactory.class));
		
	}

}
