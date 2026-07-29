package S_main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import S_beans.SeasonFinder;

public class DependencyInjectionTester {
        public static void main(String[] args) {
//			create IOC container 
        	FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext("src/S_configuration/applicationContext.xml");
        	// get Target Spring bean class obj ref and type cast the object
        	SeasonFinder sf = (SeasonFinder) ctx.getBean("sf");
//        	invoke the Business Method
        	try {
        		String msg = sf.showSeasonName();
        		System.out.println("Season Name :: "+msg);
        	}
        	catch (Exception e) {
				// TODO: handle exception
        		e.printStackTrace();
			}
//        	Close the IOC container
        	ctx.close();
		}
}
