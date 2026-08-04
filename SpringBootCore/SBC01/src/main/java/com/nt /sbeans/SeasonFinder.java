package com.nt.sbeans;

import java.time.LocalDate;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component("sf")
public class SeasonFinder {
	@Autowired
	private LocalDate date;
        
        public String findSeason() 
        {
        	System.out.println("SeasonFinder.findSeason()");
        	
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
