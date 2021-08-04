package com.eldem.DesingByContract;




public class BankAccount {
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public void moneyTransfer(int transferAmount)
	{
		assert balance >= 0 : "You don't have any money";
		assert transferAmount < balance : "Your ballance is outstanding";
		assert transferAmount >= 0 : "Invalid transfer amount";
		balance = balance - transferAmount;
		System.out.print("Money has been transferred. Your current balance is: "+ balance);
	}
	
}
