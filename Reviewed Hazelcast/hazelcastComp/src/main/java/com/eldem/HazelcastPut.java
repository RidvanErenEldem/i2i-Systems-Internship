package com.eldem;

import java.util.Random;

import com.Helper.InstanceCreator;
import com.Helper.Timer;
import com.hazelcast.map.IMap;

public class HazelcastPut {

	public static void main(String[] args) {
		IMap<Object, Object> map = InstanceCreator.Create();

		
		Random random = new Random();
		Timer timer = new Timer();
		timer.StartTimer();
		for(int i= 0; i < 100000; i++)
		{
			map.put(i, random.nextInt(100000));
		}
		timer.EndTimer();
	}

}
