package SB_beans;

import java.time.LocalTime;

//target bean class

public class WishMessageGenerator {

	//Has-A property (composition)
		private LocalTime time;

		//setter method for setter injection(alt+shift+s,r)
		public void setTime(LocalTime time)
		{
			System.out.println("WishmessageGenerator.setTime()");
			this.time = time;
		}
		
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


