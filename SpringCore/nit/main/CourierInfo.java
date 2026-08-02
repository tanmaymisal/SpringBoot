package com.nit.main;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nit.configurations.AppConfig;
import com.nit.sbeans.Flipkart;


public class CourierInfo {
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
