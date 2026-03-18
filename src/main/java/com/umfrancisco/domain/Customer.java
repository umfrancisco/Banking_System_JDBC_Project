package com.umfrancisco.domain;

public class Customer {
	private final int id;
	private final String name;
	private double amount;
	
	Customer(int id, String name, double amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}
	
	public int id() {
		return id;
	}
	
	public String name() {
		return name;
	}
	
	public double amount() {
		return amount;
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			this.amount += amount;
		}
	}
	
	public void withdraw(double amount) {
		if (amount > 0 && amount < this.amount) {
			this.amount -= amount;
		}
	}
	
	@Override
	public String toString() {
		return String.format("%s, $%.2f", name, amount);
	}
}
