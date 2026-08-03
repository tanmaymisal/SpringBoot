package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("vce")
@PropertySource("com/nt/commons/info.properties")
public class CheckingVottingElegibility {
        @Value("${voter.id}")
        private Integer id;
        @Value("${voter.name}")
        private String name;
        @Value("${voter.age}")
        private Integer age;
        
        private Date verifiedOn;
        public CheckingVottingElegibility()
        {
        	System.out.println("CheckingVottingElegibility::0-param constructor)");
        }
        @PostConstruct
        public void myInit() 
        {
        	System.out.println("CheckingVottingEligibility.myInit()");
//        	initialized the left over properties that had not paritcipated in the injection
            verifiedOn = new Date();
//            validation logics
            if(name==null || age<0 || age>130) 
            {
            	throw new IllegalArgumentException("please enter correct Arguments");
            }
            
        }
//        b.method
        public String checkEligibility()
        {
        	System.out.println("CheckingVottingEligibility.checkElibility()");
        	if(age<18) 
        	{
        		return "Mr/Mrs"+name+" u r not Eligible for voting --> verified on = "+verifiedOn;
        	}
        	else 
        	{
        		return "Mr/Mrs"+name+" u r Eligible for voting --> verified on = "+verifiedOn;

        	}
        }
        
        @PreDestroy
//        destroy life cycle method
        public void myDestroy() 
        {
        	System.out.println("CheckingVottingElegibility.myDestroy()");
//        	nullification of the bean properties
        	name =null;
        	age=null;
        	id=null;
        	verifiedOn = null;
        }
        
}
