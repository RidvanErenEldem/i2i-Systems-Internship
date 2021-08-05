package com.eldem.testDrivenDevelopment;

import java.util.Scanner;


/**
 * Hello world!
 *
 */
public class App 
{
	public static boolean isSquare(int input) {
		int test = (int)Math.sqrt(input);
		return test * test == input;
	}

	public static int isFibonacci(int input) {
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

		if(input == 1) {
			System.out.println("1 is not prime nor composite number");
		} else if(flag == 0 && isFibonacci(input) == 1) {
			System.out.println(input + " is prime and fibonacci");
		} else {
			System.out.println(input + " is not prime and fibonacci");
		}
	}
}
