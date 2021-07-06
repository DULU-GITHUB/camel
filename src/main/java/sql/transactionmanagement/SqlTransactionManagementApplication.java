package sql.transactionmanagement;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import sql.Employee;

@SpringBootApplication
public class SqlTransactionManagementApplication {
	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SqlTransactionManagementApplication.class, args);
		ProducerTemplate pr=ctx.getBean(ProducerTemplate.class);
		Employee emp=new Employee("empID02","EmployeeNAME02");
		pr.requestBody("direct:insert", emp, List.class);
		
	}

}
