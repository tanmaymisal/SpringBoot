package SB_Beans;
//target Spring bean

import java.time.LocalDate;

/**
 * 
 */
public class seasonNameGenerator {
    
	private LocalDate date;

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	public String showSeason() {
		System.out.println("seasonMessageGenerator.showSeason()");
		
		int month = date.getMonthValue();
	
		if(month >= 2 && month < 6) {
			return "summer";
		}
		else if(month >= 6 && month < 10) {
			return "rainy";
		}
		else {
			return "winter";
		}
	}
	
	
	
}
