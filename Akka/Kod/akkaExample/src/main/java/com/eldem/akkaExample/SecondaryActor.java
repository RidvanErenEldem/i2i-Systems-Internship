package com.eldem.akkaExample;

import akka.actor.AbstractActor;

public class SecondaryActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, msg -> { System.out.println(msg+ sender());}).build();
	}

}
