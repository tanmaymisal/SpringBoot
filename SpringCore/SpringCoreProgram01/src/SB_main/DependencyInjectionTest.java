package SB_main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import SB_beans.WishMessageGenerator;

public class DependencyInjectionTest {

	public static void main(String[] args) {
//		Create IOC Container
//	FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/SB_configurations/applicationContext.xml");
//		Object obj =  ctx.getBean("Wmg");
//		WishMessageGenerator generator = (WishMessageGenerator) obj;
//		String msg  = generator.showWishMessage("Tanmay");
//		System.out.println("Result : "+msg);	
		//create IOC container
FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/SB_configuration/applicationContext.xml");
				
				//get target Spring bean class obj ref
				Object obj=ctx.getBean("wmg");
				
				//Type casting
				WishMessageGenerator generator=(WishMessageGenerator)obj;
				
				//invoke the b.methods
				String msg=generator.showWishMessage("raja");
				System.out.println("result: "+msg);
				
				//close the IOC container
				ctx.close();

	}
}
