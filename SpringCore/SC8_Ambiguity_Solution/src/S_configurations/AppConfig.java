package S_configurations;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "S_beans")
public class AppConfig {
       @Bean(name="ldate4")
       public LocalDate createDate4()
       {
    	   System.out.println("AppConfig.createLDate4()");
    	   return LocalDate.now();
       }
       @Bean(name="ldate1")
       public LocalDate createLdate1()
       {
    	   System.out.println("AppConfig.createLDate1()");
    	   return LocalDate.of(2002, 06, 22);
       }
       
       @Bean(name="ldate2")
       public LocalDate createLdate2()
       {
    	  System.out.println("AppConfig.createLdate2()");
    	  return LocalDate.of(2000, 10, 20);
       }
       
       @Bean(name="ldate3")
       public LocalDate createDate3()
       {
    	   System.out.println("AppConfig.createDate3()");
    	   return LocalDate.of(2001, 10, 20);
       }
       
       @Bean(name="time")
       public LocalTime createTime()
       {
    	   System.out.println("AppConfig.createTime()");
    	   return LocalTime.now();
       }
}
