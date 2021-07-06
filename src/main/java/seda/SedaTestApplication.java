package seda;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@SpringBootApplication
public class SedaTestApplication {
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SedaTestApplication.class, args);
		ProducerTemplate pr=ctx.getBean(ProducerTemplate.class);
		pr.sendBody("direct:testSeda","start message");
	}

}
