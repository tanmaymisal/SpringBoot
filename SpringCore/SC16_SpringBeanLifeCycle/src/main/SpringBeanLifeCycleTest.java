package com.nt.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.configuration.AppConfig;
import com.nt.sbeans.CheckingVottingElegibility;

public class SpringBeanLifeCycleTest {
public static void main(String[] args) {
//	create IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	get target spring bean class obj ref
	CheckingVottingElegibility voter = ctx.getBean("vce",CheckingVottingElegibility.class);
//	invoking business methods
	try {
		String result = voter.checkEligibility();
		System.out.println(result);
	} catch (Exception e) {
		e.printStackTrace();
	}
//	Close the container
	ctx.close();
}
}
