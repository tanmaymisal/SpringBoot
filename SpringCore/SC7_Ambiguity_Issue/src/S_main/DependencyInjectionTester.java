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
    	   AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(S_configurations.AppConfig.class);
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
//  This program will generate Ambiguity issue 
//because in bean file or bean.class we don't have specify 
//which date we required among the createDate() methods available in appConfig Configuration class
// So when we run main/client class then the class will generate ambiguity issue becauese we have 4 date method 
//so the ioc container get's issue in selecting one method among these 4

//ERROR Message :-
//No qualifying bean of type 'java.time.LocalDate' available: expected single matching bean but found 4: ldate4,ldate1,ldate2,ldate3

 //So in Order to Solve this issue by using the following solutions :
/*a. Using @Primay (annotation driven configurations) or primary = "true" attribute of <bean> (in xml driven configurations).
   example :
	   
	       @Configuration
	       @ComponentScan(basePackages= "S_beans")
	    	public AppConfig
	    	{
	 				// predefined class as the spring bean
					@Bean(name  = "ldate")
					@Primary // because of this the first @Bean method based spring bean class object is injected
					public LocalDate createDate() 
					{
						return LocalDate.now();
					}
					@Bean(name  = "ldate1")
					public LocalDate createDate() 
					{
						return LocalDate.now();
					}
	    	}
	  

b. Using @Qualifier (annotation)-> Recommended to use (Best among others)
example :
	   
    @Configuration
    @ComponentScan(basePackages= "S_beans")
 	public AppConfig
 	{
				// predefined class as the spring bean
				@Bean(name  = "ldate")
				public LocalDate createDate() 
				{
					return LocalDate.now();
				}
				@Bean(name  = "ldate1")
				public LocalDate createDate() 
				{
					return LocalDate.now();
				}
 	}

    @component("wdf")
    public class WeekDayFinder
    {
    	@Autowired
    	@Qualifier("ldate1")  :-> Since "ldate1" is specified in @Qualifier annotation we can say second @bean method  that is returning LocalDate clas obh will be injected
    	private LocalDate date;
    	@Autowired
    	private LocalTime time;
        .....
        ....
        ....
    }

c. By matching target Spring bean HAS-A property name with one of the possible dependent spring bean id/name;
      example :
    	  
    	  @component("wdf")
      public class WeekDayFinder
      {
      	@Autowired
      	@Qualifier("date") 
      	private LocalDate date;
      	@Autowired
      	private LocalTime time;
          .....
          ....
          ....
      }
      
      @Configuration
      @ComponentScan(basePackages= "S_beans")
   	public AppConfig
   	{
  				// predefined class as the spring bean
  				@Bean(name  = "date") // though there are two matchings the second @bean  method based LocalDate class object will be injected becoz the HAS-A  property name("date") and the dependent bean id name(date) are matching
  				public LocalDate createDate() 
  				{
  					return LocalDate.now();
  				}
  				@Bean(name  = "ldate1")
  				public LocalDate createDate() 
  				{
  					return LocalDate.now();
  				}
   	}*/
      
      
      
