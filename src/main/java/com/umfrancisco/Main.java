package com.umfrancisco;

import java.util.Random;

import com.umfrancisco.dao.BankDAO;
import com.umfrancisco.domain.Bank;

public class Main {
	public static void main(String[] args) {
		BankDAO dao = new BankDAO();
		Bank bank = new Bank(100, "São Paulo");
		String[] names = {"Ann", "Bob", "Carole", "Dave", "Ed"};
		int size = names.length;
		
		for (int i = 0; i < 25; i++) {
			bank.addNewCustomer(i, names[i % size], new Random().nextDouble(1000));
		}
		for (var customer : bank.customers()) {
			dao.add(customer, bank);						
		}
		
	}
}
