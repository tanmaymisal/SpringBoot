package com.nt.main;


import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.configurations.AppConfig;

public class Spring_i18_Test {
public static void main(String[] args) {
	
//  create IOC container
	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//	read language code and country code from the end user
	Scanner sc  = new Scanner(System.in);
	System.out.println("Enter language code ::");
	String lang1 = sc.nextLine();
	System.out.println("Enter country code::");
	String country = sc.nextLine();
	
//	prepare Locale object having language code +country code
//	Locale locale =  new Locale(lang,country); DEPRECATED in java 19
	Locale locale = Locale.of(lang1, country);
//	read the message from the locale specific properties file using the ctx.getMessage() method
	
String m1 = ctx.getMessage("welcome.msg",new Object[] {"tanmay"},locale);
String m2 = ctx.getMessage("goodbye.msg",new Object[] {"tanmay"},locale);
String m3 = ctx.getMessage("wish.msg",new Object[] {"tanmay"},locale);

//display the message 
System.out.println(m1+"\n"+m2+"\n"+m3);
//close the  the container
ctx.close();
	}
}
