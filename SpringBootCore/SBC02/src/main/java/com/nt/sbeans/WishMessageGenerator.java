package com.nt.sbeans;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//target bean class
@Component("wmg")
public class WishMessageGenerator {

	//Has-A property (composition)
	@Autowired
		private LocalTime time;

		
		//b.method
		public String showWishMessage(String user) {
System.out.println("WishmessageGenerator.showWishMessage()");
			
			//get current hours of the day
			int hours=time.getHour();
			
			//generate wish message
			
			if(hours<12)
				return "Good Morning: "+user;
			else if(hours<16)
				return "Good Afternoon: "+user;
			if(hours<18)
				return "Good Evening: "+user;
			else
				return "Good Night: "+user;
		}
		

	
}



