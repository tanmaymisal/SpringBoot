package com.nit.sbeans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("prn")
@Scope("prototype")
public class Printer {
        private static Printer INSTANCE;
        
//        private constructor
        private Printer () 
        {
        	System.out.println("Printer :: 0-param constructor)");
        }
        
//        static factory method having singleton logic
        public static Printer getInstance() 
        {
        	if(INSTANCE ==null) 
        	{
        		INSTANCE = new Printer();
        	}
        	return INSTANCE;
        }
// business method
        public void printMessage(String msg) 
        {
        	System.out.println(msg);
        }
}
