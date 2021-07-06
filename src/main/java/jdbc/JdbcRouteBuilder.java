package jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

import sql.Employee;

@Service
public class JdbcRouteBuilder extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		// Select Route
				/*from("direct:jdbcselect").setBody(constant("select * from employee")).to("jdbc:dataSource")
						.process(new Processor() {
							public void process(Exchange xchg) throws Exception {
							   //the camel jdbc select query has been executed. We get the list of employees.
								ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn()
										.getBody();
								List<Employee> employees = new ArrayList<Employee>();
								System.out.println(dataList);
								for (Map<String, String> data : dataList) {
									Employee employee = new Employee();
									employee.setEmpId(data.get("empId"));
									employee.setEmpName(data.get("empName"));
									employees.add(employee);
								}
								xchg.getIn().setBody(employees);
							}
						});*/
		
	}

}
