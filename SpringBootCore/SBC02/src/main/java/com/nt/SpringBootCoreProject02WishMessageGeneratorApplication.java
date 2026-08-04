package com.nt;

import java.time.LocalTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
public class SpringBootCoreProject02WishMessageGeneratorApplication {

@Bean(name="msg")
public LocalTime currentTime() 
{
           return LocalTime.now();	
}
	public static void main(String[] args) {
//		get IOC container
		ApplicationContext ctx = SpringApplication.run(SpringBootCoreProject02WishMessageGeneratorApplication.class, args);
//		get target Spring bean object reference
		WishMessageGenerator wmg = ctx.getBean("wmg",WishMessageGenerator.class);
//		Invoke business method
	      System.out.println("Enter the name for whom message is generating");
	      Scanner sc = new Scanner (System.in);
		String name = sc.next();
		System.out.println(wmg.showWishMessage(name));
//		Close IOC container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
