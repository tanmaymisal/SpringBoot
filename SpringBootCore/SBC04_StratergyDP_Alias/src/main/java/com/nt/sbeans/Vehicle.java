package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("vehicle")
public class Vehicle {

@Autowired
@Qualifier("motor")
private IEngine eng;

    

public void journey(String start,String  end) 
{
         eng.startEngine();
         
         System.out.println("Journey start's from "+start);
         System.out.println("journey is going on......");
         try
         {
        	Thread.sleep(400); 
         }
         catch
         (InterruptedException e) 
         {
        	 System.out.println(e.getMessage());
         }
         System.out.println("Journey is ends at "+end);
         eng.stopEngine();
}
}
