package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("eEng")
public class ElectricEngine implements IEngine {

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
       System.out.println("Electric Engine Started...");
	}

	@Override
	public void stopEngine() {
		// TODO Auto-generated method stub
	       System.out.println("Electric Engine Stopped...");

	}

}
