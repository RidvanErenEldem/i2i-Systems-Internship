package com.eldem.FibPrime;

public class Checker implements CheckerInterface {

	public boolean isPrime(int number) {
		if(number == 2)
			return true;
		
		if(number%2 == 0)
			return false;
		
		for(int i= 3; i<(int) Math.sqrt(number);i++)
		{
			if(number%i == 0)
				return false;
		}
		return true;
	}
	
	private boolean isPerfectSquare(int number)
	{
		int sqrtNumber = (int) Math.sqrt(number);
		return (sqrtNumber*sqrtNumber == number);
	}
	public boolean isFibonacci(int number) {
		return isPerfectSquare(5*number*number + 4) || isPerfectSquare(5*number*number -4);
	}

	public boolean isFibPrime(int number) {
		return isFibonacci(number) && isPrime(number);
	}

}
