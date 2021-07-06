package sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.sql.SqlComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class SqlRouteBuilder extends RouteBuilder {

	@Autowired
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void configure() throws Exception {
		DataSource ds=dataSource;
		// Select Route
		from("direct://select").to("sql:select * from employee?dataSource=dataSource").process(new Processor() {
			public void process(Exchange xchg) throws Exception {
				// the camel sql select query has been executed. We get the list
				// of employees.
				ArrayList<Map<String, String>> dataList = (ArrayList<Map<String, String>>) xchg.getIn().getBody();
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
		});

	}

}
