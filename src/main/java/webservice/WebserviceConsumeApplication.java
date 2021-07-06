package webservice;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.sun.xml.bind.v2.schemagen.xmlschema.List;

@SpringBootApplication
@ComponentScan("webservice,configuration")
public class WebserviceConsumeApplication {
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(WebserviceConsumeApplication.class, args);
		ProducerTemplate pr=ctx.getBean(ProducerTemplate.class);
		List data=pr.requestBody("direct:getdata",null,List.class);
	}

}
