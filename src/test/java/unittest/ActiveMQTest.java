package unittest;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(CamelSpringBootRunner.class)
public class ActiveMQTest {

	@Autowired
	ProducerTemplate producerTemplate;

	@Test
	public void testPayloadIsReached() throws InterruptedException {		
		System.out.println("This is ActiveMQTest class");
		CamelSpringBootRunner c;
		
	}

}