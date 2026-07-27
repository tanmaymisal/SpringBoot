package SB_main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import SB_Beans.seasonNameGenerator;


public class dependencyInjectionTester1 {
	public static void main(String[] args) {
//		Create IOC Container
	FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/SB_confuguration/applicationContext.xml");
		Object obj =  ctx.getBean("smg");
		seasonNameGenerator generator = (seasonNameGenerator) obj;
		String msg  = generator.showSeason();
		System.out.println("Result : "+msg+" season");
		
	}
}
