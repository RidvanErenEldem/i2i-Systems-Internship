package com.eldem;

import com.Helper.InstanceCreator;
import com.Helper.Timer;
import com.hazelcast.map.IMap;

public class HazelCastGet {

	public static void main(String[] args) {
		IMap<Object, Object> map = InstanceCreator.Create();
		
		Object rand = 0; // Random
		Timer timer = new Timer();
		timer.StartTimer();
		for(int i= 0; i < 20000; i++)
		{
			rand = map.get(i);
		}
		timer.EndTimer();
	}
}
