package com.nt;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class SpringBootCoreProject05StgyDpAlias2Application {

	public static void main(String[] args) {
//		get IOC container
		ApplicationContext ctx = SpringApplication.run(SpringBootCoreProject05StgyDpAlias2Application.class, args);
// get target Spring bean class object reference
		Vehicle v = ctx.getBean("vehicle",Vehicle.class);
//		invoke business class method 
		v.journey("Kamargaon", "Amarvati");
//		close IOC container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
