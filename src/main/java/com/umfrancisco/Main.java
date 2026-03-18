package com.umfrancisco;

import java.util.Random;
import com.umfrancisco.dao.BankDAO;
import com.umfrancisco.domain.Bank;

public class Main {
	public static void main(String[] args) {
		BankDAO dao = new BankDAO();
		Bank bank = new Bank(100, "São Paulo");
		addRandomCustomers(dao, bank);
		dao.selectAll();
	}
	
	public static void addRandomCustomers(BankDAO dao, Bank bank) {
		String[] names = {"Ann", "Bob", "Carole", "Dave", "Ed", "Fred", "Gerald"};
		Random random = new Random();
		int size = names.length;
		
		for (int i = 0; i < 50; i++) {
			dao.addNewCustomer(bank, random.nextInt(9999), names[i % size], random.nextDouble(1000));
		}
	}
}
