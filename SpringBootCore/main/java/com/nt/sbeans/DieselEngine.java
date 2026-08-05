package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("dEng")

public class DieselEngine implements IEngine {

	@Override
	public void startEngine() {
		// TODO Auto-generated method stub
       System.out.println("DieseL Engine Started...");
	}

	@Override
	public void stopEngine() {
		// TODO Auto-generated method stub
	       System.out.println("DieseL Engine Stopped...");

	}

}
