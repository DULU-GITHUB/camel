package sql;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SqlApplication {
	@Autowired
	ProducerTemplate producerTemplate;
	
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SqlApplication.class, args);
		ProducerTemplate producerTemplate1=ctx.getBean(ProducerTemplate.class);
		System.out.println("trying to get bean : "+producerTemplate1);
		
		List<Employee> employees = producerTemplate1.requestBody("direct:select", null, List.class);
		System.out.println(employees);
		
		
	}

}
