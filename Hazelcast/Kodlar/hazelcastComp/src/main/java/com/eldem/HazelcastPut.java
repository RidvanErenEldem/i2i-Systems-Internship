package com.eldem;

import java.util.Random;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class HazelcastPut {

	public static void main(String[] args) {
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Object, Object> map = hz.getMap("mapTest");
		
		Random rand = new Random();
		long startTime = System.nanoTime();
		for(int i= 0; i < 100000; i++)
		{
			map.put(i, rand.nextInt(100000));
		}
		long endTime = System.nanoTime()- startTime;
		double passedSeconds = (double)endTime / 1000000000.0;
		System.out.print(passedSeconds);
	}

}
