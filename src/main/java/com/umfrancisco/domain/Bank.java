package com.umfrancisco.domain;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	
	private int bankNumber;
	private String name;
	private List<Customer> customers = new ArrayList<>();
	
	public Bank(int bankNumber, String name) {
		this.bankNumber = bankNumber;
		this.name = name;
	}
	
	public int bankNumber() {
		return bankNumber;
	}
	public String name() {
		return name;
	}
	public List<Customer> customers() {
		return customers;
	}
	
	public Customer getCustomer(int id) {
		for (var customer : customers) {
			if (customer.id() == id) {
				return customer;
			}
		}
		return null;
	}
	
	public void addNewCustomer(int id, String name, double amount) {
		if (getCustomer(id) == null) {
			Customer customer = new Customer(id, name, amount);
			customers.add(customer);
			System.out.println("New customer added: "+customer);
		}
	}
	
	@Override
	public String toString() {
		return bankNumber+", "+customers;
	}
}
