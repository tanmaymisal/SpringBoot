package com.nt.commonInterfaces;

import org.springframework.stereotype.Component;

@Component("bDart")
public class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		// TODO Auto-generated method stub
		return "DTDC is delivering"+oid;
	}

}
