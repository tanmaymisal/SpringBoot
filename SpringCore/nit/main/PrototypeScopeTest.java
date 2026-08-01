package com.nit.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import com.nit.configurations.AppConfig;
import com.nit.sbeans.Printer;

public class PrototypeScopeTest {
       public static void main(String[] args) {
//		create IOC container
    	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//    	   get spring bean class objects
     	   Printer p1 = ctx.getBean("prn",Printer.class);    // gives two different hashCodes 
    	   Printer p2 = ctx.getBean("prn",Printer.class);   // (This real singleton java class behaviour is broken)
    	   System.out.println(p1.hashCode()+" "+p2.hashCode());// [Reason the IOC container is not doing static factory method based instantiation for the singleton java class 
    	                                                       // it is instantiating directly by using O-param private constructor] 
    	                                                       // by accessing the private constructor using reflection api
    	   
    	   System.out.println("============================");
//    	   get Spring bean class objects
    	                                                   //gives same hashCodes becoz the singleton java class is getting
    	   Printer p3 = ctx.getBean("prn1",Printer.class); //instantiated through static factory method where the singleton 
    	   Printer p4 = ctx.getBean("prn1",Printer.class); //logic is available
    	   System.out.println(p3.hashCode()+" "+p4.hashCode());//
    	   
	}
}
 
