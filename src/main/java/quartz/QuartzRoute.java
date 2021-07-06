package quartz;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Service;

@Service
public class QuartzRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		/*CronScheduledRoutePolicy startPolicy = new CronScheduledRoutePolicy();
		startPolicy.setRouteStartTime("* * * * *");*/

		from("file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\camel data folder\\infolder?noop=true&scheduler=quartz2&scheduler.cron=0 * * * * ? *")
		//scheduler.cron=0 0/1 * 1/1 * ? *
	//	.routePolicy(startPolicy).noAutoStartup()
				.process(new Processor(){

					@Override
					public void process(Exchange exchange) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("quartz check");
					}
					
				})
				.to("file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\camel data folder\\outfolder");
	}

}
