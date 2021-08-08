package com.eldem.KafkaFibPrime;

import java.util.concurrent.LinkedBlockingQueue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eldem.FibPrime.Checker;

public class Processor implements Runnable {
	private LinkedBlockingQueue<NumOp> received;
	private Checker checker;
	
	private final Logger logcu = LogManager.getLogger(Processor.class);
	
	public Processor(LinkedBlockingQueue<NumOp> received)
	{
		this.received = received;
		checker = new Checker();
	}
	
	
	private void opChooser(NumOp numOp)
	{
		String op = numOp.getOp();
		int number = numOp.getNumber();
		
		String logData = "Operation is: " + op +" Number is: " + number +" and retrun is: ";
		boolean value = false;
		
		switch(op)
		{
			case "fib":
				value = checker.isFibonacci(number);
				logcu.info(logData + value);
				break;
			case "prime":
				value = checker.isPrime(number);
				logcu.info(logData + value);
				break;
			case "fibPrime":
				value = checker.isFibPrime(number);
				logcu.info(logData + value);
				break;
			default:
				logcu.error(op + " is wrong");
		}
		
	}

	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted())
		{
			try
			{
				opChooser(received.take());
			}
			catch(InterruptedException e)
			{
				Thread.currentThread().interrupt();
			}
		}
		
	}
	

}
