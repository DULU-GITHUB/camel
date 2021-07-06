package eip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("eip,configuration")
public class EIPApplication {
	public static void main(String[] args) {
		SpringApplication.run(EIPApplication.class, args);
	}

}
