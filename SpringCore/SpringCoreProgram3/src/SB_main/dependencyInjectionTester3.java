package SB_main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import SB_beans.weekWorkingDayFinder;

public class dependencyInjectionTester3 {
 public static void main(String [] args) 
 {
	 FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/SB_configurations/applicationContext.xml");
	 Object obj = ctx.getBean("wwdf");
	 weekWorkingDayFinder wday = (weekWorkingDayFinder) obj;
	 String msg = wday.ShowDay();
	 System.out.println("Result : "+msg);
 }
}
