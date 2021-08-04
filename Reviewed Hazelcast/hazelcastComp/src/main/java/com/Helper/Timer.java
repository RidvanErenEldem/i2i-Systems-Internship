package com.Helper;

public class Timer {
	private double passedSecond;
	private long startTime;
	private long processTime;
	
	public void StartTimer()
	{
		startTime = System.nanoTime();
	}
	public void EndTimer()
	{
		processTime = System.nanoTime() - startTime;
		passedSecond = (double) processTime / 1000000000.0;//Converting nano seconds to seconds
		System.out.print(passedSecond);
		passedSecond = startTime = processTime = 0;
	}
}
