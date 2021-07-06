package sql.transactionmanagement;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import sql.Employee;

@Service
public class SqlTranManagementRoute extends RouteBuilder{
	
	 // Create Transaction Manager
		@Bean
		public PlatformTransactionManager transactionManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}

	    // Specify Spring Transaction Management Policy
		@Bean(name = "PROPAGATION_REQUIRED")
		public SpringTransactionPolicy propogationRequired(PlatformTransactionManager transactionManager) {
			SpringTransactionPolicy propagationRequired = new SpringTransactionPolicy();
			propagationRequired.setTransactionManager(transactionManager);
			propagationRequired.setPropagationBehaviorName("PROPAGATION_REQUIRED");
			return propagationRequired;
		}

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		 //Insert Route
		from("direct:insert").transacted("PROPAGATION_REQUIRED").log("Processing message: ").process(new Processor() {
			public void process(Exchange xchg) throws Exception {
			    //take the Employee object from the exchange and create the parameter map
				Employee employee = xchg.getIn().getBody(Employee.class);
				Map<String, Object> employeeMap = new HashMap<String, Object>();
				employeeMap.put("EmpId", employee.getEmpId());
				employeeMap.put("EmpName", employee.getEmpName());
				xchg.getIn().setBody(employeeMap);
			}
		}).to("sql:INSERT INTO employee(EmpId, EmpName) VALUES (:#EmpId, :#EmpName)?dataSource=dataSource").
			process(new Processor() {
					public void process(Exchange xchg) throws Exception {
					// throw an exception after insert statement.
						System.out.println("Exception Occurred");
						throw new Exception();
					}
				});
		
	}

	

}
