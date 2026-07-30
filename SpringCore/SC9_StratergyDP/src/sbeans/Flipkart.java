package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.nt.commonInterfaces.Courier;
@Component("fpkt")
public final class Flipkart {
//	HAS-A Property
	@Autowired
	@Qualifier("bDart")
     private Courier courier;
     
// setter method
     public void setCourier(Courier courier) 
     {
    	 this.courier = courier; 
     }
// Business method
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
//    	  deliver the products using courier
    	 String msg = courier.deliver(oid);
    	 
    	 return Arrays.toString(items)+"items with bill Amount :: "+sum+"----"+msg;
     }
     
}
