package marshallunmarshall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("marshallunmarshall,configuration")
public class MarshallAndUnmarshallApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarshallAndUnmarshallApplication.class, args);
		
	}

}
