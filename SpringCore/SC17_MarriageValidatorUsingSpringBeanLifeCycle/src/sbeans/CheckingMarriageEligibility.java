package com.nt.sbeans;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("marriage")
@PropertySource("com/nt/commons/info.properties")
public class CheckingMarriageEligibility {
	
	@Value("${person.name}")
	private String name;
	@Value("${person.gen}")
	private String gender;
	@Value("${person.age}")
	private Integer age;
	
	private Date verifiedOn;
	
	public CheckingMarriageEligibility() 
	{
		System.out.println("CheckingMarriageEligibility:: ) 0-argument constructor");	
	}
	@PostConstruct
	public void myInit()
	{
		System.out.println("CheckingMarriageEligibility.myInit()");
		verifiedOn = new Date();
		if(!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female")) 
		{
			throw new IllegalArgumentException("Invalid Gender");
		}
		else if(age<=0 || age >=50)
		{
			throw new IllegalArgumentException("Invalid Age input");
		}
		else if(name == null){
			throw new NullPointerException("Please provide the name of person");
		}
	}
//	business method
	public String checkEligibility() 
	{   
		String result = null;
		if(gender.equalsIgnoreCase("male")) 
		{
			if(age>=21) 
			{
				result = name+" u r Eligible for merriage  verfied on -->Date ::"+verifiedOn ;
			}
			else 
			{
				result=  name+" u r not Eligible for merriage  verfied on -->Date ::"+verifiedOn ;
			}
		}
		else {
			if(age>=18) 
			{
				result = name+" u r Eligible for merriage  verfied on -->Date ::"+verifiedOn ;
			}
			else 
			{
				result = name+" u r not Eligible for merriage  verfied on -->Date ::"+verifiedOn ;
			}
		}
		
		return result;
		
		
		
	}
	@PreDestroy
	public void myDestroy() 
	{
		name = null;
		age=null;
		gender = null;
		verifiedOn = null;
	}

}
