package com.umfrancisco;

import java.util.Random;

import com.umfrancisco.dao.BankDAO;
import com.umfrancisco.domain.Bank;

public class Main {
	public static void main(String[] args) {
		BankDAO dao = new BankDAO();
		Bank saoPauloBank = new Bank(100, "São Paulo");
		Bank buenosAiresBank = new Bank(200, "Buenos Aires");
		addRandomCustomers(dao, saoPauloBank);
		addRandomCustomers(dao, buenosAiresBank);
		dao.selectAll(100);
		dao.selectAll(200);
	}
	
	public static void addRandomCustomers(BankDAO dao, Bank bank) {
		String[] names = {"Ann", "Bob", "Carole", "Dave", "Ed", "Fred", "Gerald"};
		Random random = new Random();
		int size = names.length;
		
		for (int i = 0; i < 200; i++) {
			bank.addNewCustomer(random.nextInt(9999), names[i % size], random.nextDouble(1000));
		}
		for (var customer : bank.customers()) {
			dao.add(customer, bank);						
		}
	}
}
