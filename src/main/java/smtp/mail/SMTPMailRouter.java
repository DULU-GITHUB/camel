package smtp.mail;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class SMTPMailRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub

		/*from("direct:sendMail").doTry().setHeader("subject", simple("SMTP Mail check"))
				.setHeader("to", simple("manoranjangharai@gmail.com")).process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("check 2");
					}
				}).to("smtps://smtp.gmail.com:465?username=g6.manoranjan@gmail.com&password=setsetgo")
				.doCatch(Exception.class).process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("handling ex");
						final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
						System.out.println(ex);
					}
				});*/

		from("direct:sendMail").doTry().process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("check 2");
			}
		}).to("smtps://smtp.gmail.com:465?username=g6.manoranjan@gmail.com&password=setsetgo&subject=SMTP Mail check&to=manoranjangharai@gmail.com")
				.doCatch(Exception.class).process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("handling ex");
						final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
						System.out.println(ex);
					}
				});
	}
}
