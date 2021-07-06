package sql;

import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	ProducerTemplate producerTemplate;
	
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public void getEmployee()
	{
		System.out.println("producer template is : "+producerTemplate);
		List<Employee> employees = producerTemplate.requestBody("direct:select", null, List.class);
		System.out.println(employees);
	}

}
