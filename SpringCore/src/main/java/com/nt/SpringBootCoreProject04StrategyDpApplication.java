package com.nt;

import com.nt.sbeans.Vehicle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootCoreProject04StrategyDpApplication {

  

        
	public static void main(String[] args) {
//		get IOC container
		ApplicationContext ctx = SpringApplication.run(SpringBootCoreProject04StrategyDpApplication.class, args);
// get target Spring bean class object reference
		Vehicle v = ctx.getBean("vehicle",Vehicle.class);
//		invoke business class method 
		v.journey("Kamargaon", "Amarvati");
//		close IOC container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
