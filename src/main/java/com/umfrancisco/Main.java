package com.umfrancisco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

import com.umfrancisco.dao.BankDAO;
import com.umfrancisco.domain.Bank;

public class Main {
	public static void main(String[] args) {
		BankDAO dao = new BankDAO();
		Bank saoPauloBank = new Bank(100, "São Paulo");
		Bank buenosAiresBank = new Bank(200, "Buenos Aires");
//		addRandomCustomers(dao, saoPauloBank);
//		addRandomCustomers(dao, buenosAiresBank);
//		dao.selectAll(100);
//		dao.selectAll(200);
		writeLog(dao, 100);
		writeLog(dao, 200);
	}
	
	public static void writeLog(BankDAO dao, int bankNumber) {
		String content = dao.selectAll(bankNumber);
		try {
			Files.writeString(Paths.get("log_bank_%d.txt".formatted(bankNumber)), content);
			System.out.println("Log written successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
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
