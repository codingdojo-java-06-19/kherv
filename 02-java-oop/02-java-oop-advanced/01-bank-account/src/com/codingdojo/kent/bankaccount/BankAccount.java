package com.codingdojo.kent.bankaccount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BankAccount {
	public static String accountNumer;
	//public static double totalMoneyStored;
	private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>(); // multiple account objects
	public static int numAccounts;
	public double checkingBalance;
	public double savingsBalance;
	public long accountNumber;

	public BankAccount() {
		numAccounts++;
		this.accountNumber = getAccountNumber();
		System.out.println("New user account created with Account Number:  " + this.accountNumber);
		accounts.add(this); // every time we create a bank account, added the account to the array...handy for things like iterating for total money
	}

	public void deposit(String accountType, double amount) {
		if (accountType == "checking") {
			this.checkingBalance += amount;
		} else {
			this.savingsBalance += amount;
		}
		// totalMoneyStored +=amount; dumped for new method
	}

	public double getCheckingBalance() {
		return this.checkingBalance;
	}

	public double getSavingsBalance() {
		return this.savingsBalance;
	}

	public void withdrawChecking(double amount) {
		if (this.checkingBalance < amount) {
			System.out.println("Account# " + this.accountNumber
					+ " Withdrawal Denied, insufficient Funds. Your checking balance is:  " + this.checkingBalance);
		} else {
			this.checkingBalance -= amount;
			System.out.println("Account# " + this.accountNumber + " Withdrew " + amount + " and new balance is:  "
					+ this.checkingBalance);
		}
	}

	public void getBalances() {
		System.out.println("Account# " + this.accountNumber + " Your checking balance is:  " + this.checkingBalance
				+ " and your savings balnace is:  " + this.savingsBalance);
	}

	public static long getAccountNumber() {
		Random rnd = new Random();
		char[] digits = new char[10];
		digits[0] = (char) (rnd.nextInt(9) + '1');
		for (int i = 1; i < digits.length; i++) {
			digits[i] = (char) (rnd.nextInt(10) + '0');
		}
		return Long.parseLong(new String(digits)); 
	}

	// added during lecture
	public static double getTotalAmount() {
			double sum=0;
			for(BankAccount account : accounts) {
				sum += account.checkingBalance + account.savingsBalance;
			}
			return sum;
		}

	
//	public static double getTotalAmount() {
//		double sum=0;
//		for(int i=0; i<accounts.size(); i++) {
//			BankAccount bankAccount = accounts.get(i);
//			sum += bankAccount.checkingBalance + bankAccount.savingsBalance;
//		}
//		return sum;
//	}
	
	
	
//	public static double getTotalAmount() {
//		double sum=0;
//		for(int i=0; i<accounts.size(); i++) {
//			sum += accounts.get(i).checkingBalance + accounts.get(i).savingsBalance;
//		}
//		return sum;
//	}
	
	
	
	//////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BankAccount fred = new BankAccount();
		BankAccount larry = new BankAccount();

		fred.deposit("checking", 1000);
		larry.deposit("notchecking", 10000);

		fred.getBalances();
		larry.getBalances();

		fred.withdrawChecking(100);
		larry.withdrawChecking(500);

		fred.getBalances();
		larry.getBalances();
		
		double resultTotal = BankAccount.getTotalAmount();
		System.out.println(String.format("The total of all bank accounts is %.2f", resultTotal));
		

		// System.out.println(BankAccount.getAccountNumber());

	} // end main method

} // end class
