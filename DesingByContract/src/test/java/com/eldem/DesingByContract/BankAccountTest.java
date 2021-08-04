package com.eldem.DesingByContract;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class BankAccountTest 
{
    @Test
    public void BalanceCheck() throws InterruptedException
    {
    	BankAccount account0 = new BankAccount();
    	account0.setBalance(50000);
    	account0.moneyTransfer(650);
    	BankAccount account1 = new BankAccount();
    	account1.setBalance(3000);
    	account1.moneyTransfer(20000);
    }
}
