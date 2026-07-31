package com.nit.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nit.configurations.AppConfig;
import com.nit.sbeans.WishMessageGenerator;

public class SingletonScopeTest {
public static void main(String[] args) {
//  create the IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	get target spring bean class object
	WishMessageGenerator gen1 = ctx.getBean("wmg",WishMessageGenerator.class);
	WishMessageGenerator gen2 = ctx.getBean("wmg",WishMessageGenerator.class);
	WishMessageGenerator gen3 = ctx.getBean("wmg",WishMessageGenerator.class);
 
	System.out.println(gen1.hashCode()+" "+gen2.hashCode()+" "+gen3.hashCode());
	System.out.println("gen1==gen2?"+(gen1==gen2));
	System.out.println("gen2==ger3?"+(gen2 == gen3));
	
	System.out.println("================================");
	
	LocalDateTime ldt1 = ctx.getBean("dt",LocalDateTime.class);
	LocalDateTime ldt2 = ctx.getBean("dt",LocalDateTime.class);
	
	System.out.println(ldt1.hashCode()+" "+ldt2.hashCode());
	System.out.println("================================");
	
	LocalDateTime ldt3 = ctx.getBean("dt1",LocalDateTime.class);
	LocalDateTime ldt4 = ctx.getBean("dt1",LocalDateTime.class);
	System.out.println(ldt3.hashCode()+" "+ldt4.hashCode());


}
	
}
//Note : the singleton scope of the spring bean will be continued only when 
//factory method based spring bean instantiation is enabled on singleton java 
//class that is configuration as singleton scope spring bean

/*
* Note : With out taking spring bean class code as singleton java class code, 
* to bring the similar effect of singleton class behavior we need to take 
* spring bean scope as the "Singleton" scope
* 
* */
