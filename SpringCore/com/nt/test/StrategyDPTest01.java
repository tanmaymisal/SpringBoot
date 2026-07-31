package com.nt.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.configurations.AppConfig;
import com.nt.sbeans.Flipkart;

public class StrategyDPTest01 {
 public static void main(String[] args) {
	 //create IOC Container
	 AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	 get Target spring bean class obj
	 Flipkart fpkt = ctx.getBean("fpkt",Flipkart.class);
//	 invoke the Business methods 
	 String resultMsg = fpkt.Shopping(new String[] {"shirt","trouser"},new double[] {500d,800d});
	 System.out.println(resultMsg);
	 
//	 close the container by vanishing the objects
	 ctx.close();
	 
}
}
