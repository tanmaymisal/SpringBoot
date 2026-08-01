package com.nit.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.nit.configurarions.AppConfig;
import com.nit.sbeans.PersonalInfo;

public class PropertiesFileTest {
       public static void main(String[] args) {
//		create IOC container 
    	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    	   get target spring bean class obj  ref
    	   PersonalInfo info  = ctx.getBean("pinfo", PersonalInfo.class);
    	   System.out.println(info);
    	  info.showData();
    	   ctx.close();
	}
}
