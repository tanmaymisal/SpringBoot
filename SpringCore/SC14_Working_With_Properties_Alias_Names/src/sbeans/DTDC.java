package com.nit.sbeans;

import org.springframework.stereotype.Component;

@Component("dtdc")
public class DTDC implements Courier {

	@Override
	public String deliver(int oid) {
		// TODO Auto-generated method stub
		return "DTDC is delivering"+oid;
	}

}
