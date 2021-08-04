package com.Helper;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

public class InstanceCreator {
	public static IMap<Object, Object> Create()
	{
		HazelcastInstance hz = Hazelcast.newHazelcastInstance();
		IMap<Object, Object> map = hz.getMap("mapTest");
		return map;
	}
}
