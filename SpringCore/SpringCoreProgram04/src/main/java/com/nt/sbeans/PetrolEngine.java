package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("pEng")

public class PetrolEngine implements IEngine {

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
       System.out.println("Petrol Engine Started...");
	}

	@Override
	public void stopEngine() {
		// TODO Auto-generated method stub
	       System.out.println("Petrol Engine Stopped...");

	}

}
