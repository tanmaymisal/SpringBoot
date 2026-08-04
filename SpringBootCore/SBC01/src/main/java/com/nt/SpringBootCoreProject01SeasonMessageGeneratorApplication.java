package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.SeasonFinder;

@SpringBootApplication
public class SpringBootCoreProject01SeasonMessageGeneratorApplication {
     @Bean(name="ld")
	public LocalDate currentDate() 
	{
		return LocalDate.now();
	}
	
	public static void main(String[] args) {
//		get IOC container
		ApplicationContext ctx = SpringApplication.run(SpringBootCoreProject01SeasonMessageGeneratorApplication.class, args);
//	   get target spring bean class object reference
		SeasonFinder sf = ctx.getBean("sf",SeasonFinder.class);
//		invoke business logic
		
		System.out.println(sf.findSeason());
//		close IOC container
       ((ConfigurableApplicationContext) ctx).close();
		
	}

}
