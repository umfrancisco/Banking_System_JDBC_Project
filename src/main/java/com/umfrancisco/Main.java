package com.umfrancisco;

import com.umfrancisco.domain.Bank;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank(100, "São Paulo");
		bank.addNewCustomer(1, "Bob", 500);
		var bob = bank.getCustomer(1);
		bob.withdraw(120);
		System.out.println(bob);
	}
}
