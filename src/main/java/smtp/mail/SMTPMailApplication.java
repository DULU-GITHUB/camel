package smtp.mail;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("smtp.mail,configuration")
public class SMTPMailApplication {
	public static void main(String[] args) {
		ApplicationContext ctx1 = SpringApplication.run(SMTPMailApplication.class, args);
		ProducerTemplate pr = ctx1.getBean(ProducerTemplate.class);
		List data = pr.requestBody("direct:sendMail", null, List.class);
	}

}
