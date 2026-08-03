package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.sbeans.CheckingMarriageEligibility;

public class SpringBeanLifeCycleTest {
public static void main(String[] args) {
//	create IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(com.nt.configurations.AppConfig.class);
//	get target spring bean class obj ref
	CheckingMarriageEligibility marriage = ctx.getBean("marriage",CheckingMarriageEligibility.class);
//	invoking business methods
	try {
		String result = marriage.checkEligibility();
		System.out.println(result);
	} catch (Exception e) {
		System.err.println(e.getMessage());
	}
//	Close the container
	ctx.close();
}
}
