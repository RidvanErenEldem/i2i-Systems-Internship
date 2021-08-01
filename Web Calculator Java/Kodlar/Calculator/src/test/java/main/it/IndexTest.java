package main.it;

import static org.junit.Assert.assertEquals;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.tempuri.Calculator;

import java.util.Random;


public class IndexTest {
	private static final Logger logger  = LogManager.getLogger("Appender3");
	
	@Test
	public void testIndex() {
		try {
			Calculator calc = new Calculator();
			Random rand = new Random();
			logger.info("TEST RUN");
			for(int i = 0; i < 100; i++)
			{
				int number1 = rand.nextInt(10000);
				int number2 = rand.nextInt(10000);
				logger.debug("Olmasý gereken Sayý1 = " + number1 + " Sayý2 = " + number2 + " Toplam = " + (number1 + number2)+ " Çýkarma = "+ (number1 - number2)+ " Çarpma = "+ (number1 * number2)+ " Bölme = " +(int)Math.ceil((number1 / number2)));
				assertEquals(number1 + number2, calc.getCalculatorSoap12().add(number1, number2));
				logger.debug(calc.getCalculatorSoap12().add(number1, number2));
				assertEquals(number1 - number2, calc.getCalculatorSoap12().subtract(number1, number2));
				logger.debug(calc.getCalculatorSoap12().subtract(number1, number2));
				assertEquals(number1 * number2, calc.getCalculatorSoap12().multiply(number1, number2));
				logger.debug(calc.getCalculatorSoap12().multiply(number1, number2));
				if(number1 == number2)
				{
					assertEquals(1, calc.getCalculatorSoap12().divide(number1, number2));
					logger.debug(calc.getCalculatorSoap12().divide(number1, number2));
				}
				else if(number2 == 0)
				{
					logger.debug("0");
				}
				else if(number2 > number1)
				{
					int div =  (int) Math.ceil(number2 / number1);
					assertEquals(div, (int)Math.ceil(calc.getCalculatorSoap12().divide(number2, number1)),1);
					logger.debug(calc.getCalculatorSoap12().divide(number2, number1));
				}
				else
				{
					int div = (int) Math.ceil(number1 / number2);
					assertEquals(div, (int)Math.ceil(calc.getCalculatorSoap12().divide(number1, number2)),1);
					logger.debug(calc.getCalculatorSoap12().divide(number1, number2));
				}
					
			}
			logger.info("THE TEST RAN SUCCESSFULLY");
		} catch (Exception e)
		{
			logger.error(e);
		}
		
	}

}
