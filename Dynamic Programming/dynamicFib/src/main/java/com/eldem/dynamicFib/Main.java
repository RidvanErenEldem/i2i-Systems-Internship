package com.eldem.dynamicFib;

import java.util.Scanner;

public class Main {

	public static long recursiveFib (long number)
    {
    	if (number <= 1)
    		return number;
    	return recursiveFib(number-1) + recursiveFib(number-2);
    }
	
	public static long dynamicFib (long number)
	{
		long fib[] = new long[(int) (number+2)];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i<= number; i++)
		{
			fib[i] = fib[i-1] + fib[i-2]; 
		}
		return fib[(int) number];
	}
    
	public static void main(String[] args)
    {
    	Scanner scan = new Scanner(System.in);
    	System.out.print("Enter a number: ");
		int input = scan.nextInt();
		scan.close();
    	
		long startTime = System.nanoTime();
		long FibResult = recursiveFib((long)input);
		long processTime = System.nanoTime() - startTime;
		double passedSecond = (double) processTime / 1000000000.0;
		System.out.print("\nRecursive result is: "+ FibResult +"\nPassed time in secconds: "+passedSecond);
		passedSecond = startTime = processTime = 0;
		
		startTime = System.nanoTime();
		FibResult = dynamicFib((long)input);
		processTime = System.nanoTime() - startTime;
		passedSecond = (double) processTime / 1000000000.0;
		System.out.print("\n\nDynamic result is: "+ FibResult +"\nPassed time in secconds: "+passedSecond);
    }
}
