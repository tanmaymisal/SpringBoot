package com.nt.commonInterfaces;

import org.springframework.stereotype.Component;

@Component("dtdc")
public final class BlueDart implements Courier {

	@Override
	public String deliver(int oid) {
		// TODO Auto-generated method stub
		return "BlueDart is delivering"+oid;
	}

}
