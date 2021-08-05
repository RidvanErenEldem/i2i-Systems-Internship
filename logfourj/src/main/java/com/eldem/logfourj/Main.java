package com.eldem.logfourj;

import java.util.Scanner;

import org.apache.logging.log4j.*;


public class Main {
	
	static final Logger logcu = LogManager.getLogger(Main.class);

	public static boolean isSquare(int input) {
		logcu.debug("isSquare started input values is: "+ input);
		int test = (int)Math.sqrt(input);
		logcu.debug("input sqrt is: " + test);
		return test * test == input;
	}

	public static int isFibonacci(int input) {
		logcu.debug("isFibonacci started input value is: "+ input);
		return isSquare(5 * input * input + 4) || isSquare(5 * input * input - 4) ? 1 : 0;
	}

	public static void main(String[] args) {
		int input, flag = 0;
		
		Scanner scan = new Scanner(System.in); 
		System.out.print("Enter a number: ");
		input = scan.nextInt();
		scan.close();

		for(int i = 2; i <= input / 2; ++i) {
			if(input % i == 0) {
				flag = 1;
				break;
			}
		}
		
		logcu.debug("flag value is: "+ flag);
		logcu.debug("isFibbonaci value: "+ isFibonacci(input));

		if(input == 1) {
			System.out.println("1 is not prime nor composite number");
		} else if(flag == 0 && isFibonacci(input) == 1) {
			System.out.println(input + " is prime and fibonacci");
		} else {
			System.out.println(input + " is not prime and fibonacci");
		}
	}
}
