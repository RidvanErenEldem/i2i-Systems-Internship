package com.eldem.akkaExample;

import akka.actor.AbstractActor;

public class MainActor extends AbstractActor {


	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, msg -> { System.out.println(msg);}).build();
	}

}
