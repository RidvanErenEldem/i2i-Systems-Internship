package com.Helper;

public class Timer {
	private double passedSecond;
	private long startTime;
	private long endTime;
	
	public void StartTimer()
	{
		startTime = System.nanoTime();
	}
	public void EndTimer()
	{
		endTime = System.nanoTime() - startTime;
		passedSecond = (double) endTime / 1000000000.0;//Converting nano seconds to seconds
		System.out.print(passedSecond);
		passedSecond = startTime = endTime = 0;
	}
}
