package S_main;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import S_beans.WeekDayFinder;
import S_configuration.AppConfig;

public class DependencyInjectionTester {
       public static void main(String[] args) {
//		create IOC container
    	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    	   														// takes the given class as the Configuration class
//	get target Spring bean class object obj ref
    	   Class d1 = WeekDayFinder.class;
    	   WeekDayFinder finder = (WeekDayFinder) ctx.getBean("wdf",d1);
//    	   invoke the Business Method 
    	   System.out.println("Spring Bean successfully initialized!");
//    	   LocalTime time = ctx.getBean("time",LocalTime.class);
//    	   LocalDate date = ctx.getBean("createDate",LocalDate.class);
//           System.out.println(time+"::"+date);
    	   finder.showInjectedValues();
//        Close the IOC container
    	   ctx.close();
    	   System.out.println("DependecyInjectionTest.main()(END)");
       } 
}

  

        // You can now use the `WeekDayFinder` object
       
      
