package com.eldem.testDrivenDevelopment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Array;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    @Test
    public void successSquareTest()
    {
    	int successTestArray[] = {1,4,9,16,25,36,49,64,81,100};
    	for(int i=0; i< 10; i++)
    	{
    		assertTrue(App.isSquare(successTestArray[i]));
    	}
    }
    @Test
    public void successFibonacciTest()
    {
    	int successTestArray[] = {2,3,5,8,13,21,34,55,89,144,233};
    	for(int i=0; i< 10; i++)
    	{
    		assertEquals(1,App.isFibonacci(successTestArray[i]));
    	}
    }
    
    @Test
    public void successFlag()
    {
    	int[] successTestArray = {2,3,5,13,89,233,1597,28657,514229};
    	int flag = 0;
    	for(int j= 0; j< 9;j++)
    	{
    		flag = 0;
    		for(int i = 2; i <= Array.getInt(successTestArray, j) / 2; ++i) {
    			if(Array.getInt(successTestArray, j) % i == 0) {
    				flag = 1;
    				break;
    			}
    		}
    	}
    	assertEquals(0, flag);
    }
    
    @Test
    public void failSquareTest()
    {
    	int failTestArray[] = {3,5,10,14,15,34,42,60,88,92};
    	for(int i=0; i< 10; i++)
    	{
    		assertFalse(App.isSquare(failTestArray[i]));
    	}
    }
    @Test
    public void failFibonacciTest()
    {
    	int failTestArray[] = {4,6,9,11,15,26,37,44,78,120,133};
    	for(int i=0; i< 10; i++)
    	{
    		assertEquals(0,App.isFibonacci(failTestArray[i]));
    	}
    }
}
