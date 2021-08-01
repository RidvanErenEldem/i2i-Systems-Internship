package com.eldem;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelCastMain {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Object, Object> map = hz.getMap("mapTest");
		
		Object rand = 0;
		long startTime = System.nanoTime();
		for(int i= 0; i < 20000; i++)
		{
			rand = map.get(i);
		}
		long endTime = System.nanoTime()- startTime;
		double passedSeconds = (double)endTime / 1000000000.0;
		System.out.print(passedSeconds);
	}
}
