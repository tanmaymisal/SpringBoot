package SB_beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("wwdf") // Custom bean name
public class weekWorkingDayFinder {
    private String day;
    List<String> weekEndDays =  Arrays.asList("saturday", "sunday");    // Constructor to initialize with current day
    // Method to check if it's a working day (Monday-Friday)
    @Autowired
    public void setDay(LocalDate day) {
    	System.out.println("Date : "+day);
    	this.day = day.getDayOfWeek().toString().toLowerCase();
    	System.out.println("Day : "+this.day);
    }
    public String ShowDay() 
    {      
           if(weekEndDays.contains(day)) {
        	    return "Happy WeekEndDay....";
           }
           else 
           {
        	   return "Happy working Day....";
           }
    }
}

