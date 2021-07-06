package marshallunmarshall;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class StudentProcessor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		Student student = exchange.getIn().getBody(Student.class);
		System.out.println("Student data");
		student.setStudentName("Student Name1");
		exchange.getIn().setBody(student);
	}
}
