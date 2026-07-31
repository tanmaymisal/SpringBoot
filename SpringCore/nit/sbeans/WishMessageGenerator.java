package com.nit.sbeans;

import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//target bean class
@Component("wmg")
@Scope("singleton") // default scope is also singleton
public class WishMessageGenerator {

	//Has-A property (composition)
	@Autowired
	@Qualifier("dt")
		private LocalDateTime ldt;

		//setter method for setter injection(alt+shift+s,r)
		public void setTime(LocalDateTime time)
		{
			System.out.println("WishmessageGenerator.setTime()");
			this.ldt = time;
		}
		
		//b.method
		public String showWishMessage(String user) {
System.out.println("WishmessageGenerator.showWishMessage()");
			
			//get current hours of the day
			int hours=ldt.getHour();
			
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


