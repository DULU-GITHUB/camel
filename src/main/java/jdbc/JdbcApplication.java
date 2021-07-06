package jdbc;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.camel.ProducerTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbcApplication {
	public static void main(String[] args) throws SQLException {
		ApplicationContext ctx=SpringApplication.run(JdbcApplication.class, args);
		
		DataSource datasource=ctx.getBean(DataSource.class);
		System.out.println("datasource : "+datasource);
		//datasource.getConnection().createStatement();
		
		//ProducerTemplate pr=ctx.getBean(ProducerTemplate.class);
		//pr.requestBody("direct:jdbcselect", null, List.class);
	}

}
