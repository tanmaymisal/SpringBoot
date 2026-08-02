package com.nit.sbeans;
import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("fpkt")
@PropertySource("com/nit/commons/info.properties")
public final class Flipkart {
//	HAS-A property 
	@Autowired
	/*
	 * 
	 * @Qualifier(${courier.id}) invalid-- becoz we can not place the place holder ${<key>} in @Qualifier annotation allowed in 
	 *                           @Value annotation
	 *  @Qualifier(@Value("${courier.id}")) invalid becoz we can not place @Value annotation inside the @Qualifier annotation
	 *  @Value("${courier.id}")
	 *  private String beanid;
	 * @Qualifier("beanid) invalid becoz we can not pass variable name to @Qualifier as the bean id
	 * */
	@Qualifier("shipment")
	private Courier courier;
	// setter method
    public void setCourier(Courier courier) 
    {
   	 this.courier = courier; 
    }
//Business method
    public String Shopping(String items[],double prices[]) 
    {  // calculate bill amount  
   	 double sum = 0;
   	 for(double d : prices) 
   	 {
   		 System.out.println(d);
   		 sum+=d;
   	 }
   	 
   	 //generate the order id (random number as the order)
   	 int oid  = new Random().nextInt(1000);
//   	  deliver the products using courier
   	 String msg = courier.deliver(oid);
   	 
   	 return Arrays.toString(items)+"items with bill Amount :: "+sum+"----"+msg;
	
}
    }
