package com.umfrancisco.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import com.umfrancisco.domain.Bank;
import com.umfrancisco.domain.Customer;
import com.umfrancisco.util.DatabaseConnection;

public class BankDAO {
	
	public void addNewCustomer(Bank bank, int id, String name, double amount) {
		bank.addNewCustomer(id, name, amount);
		var customer = bank.getCustomer(id);
		add(customer, bank);
	}
	
	public void add(Customer customer, Bank bank) {
		String sql = "INSERT INTO customer(customer_id, customer_name, bank_number, customer_amount) VALUES (?,?,?,?)";
		try {
			var con = DatabaseConnection.getConnection();
			var ps = con.prepareStatement(sql);
			ps.setInt(1, customer.id());
			ps.setString(2, customer.name());
			ps.setInt(3, bank.bankNumber());
			ps.setDouble(4, customer.amount());
			ps.execute();
			System.out.println(LocalDateTime.now()+": "+sql);
			DatabaseConnection.closeConnection(con, ps, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String countCustomersPerBank(int number) {
		String result = "";
		String sql = "SELECT COUNT(*) FROM customer WHERE bank_number = "+number;
		try {
			var con = DatabaseConnection.getConnection();
			var ps = con.prepareStatement(sql);
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				int count = rs.getInt(1);
				result += "COUNT_CUSTOMERS BANK %d = %d\n".formatted(number, count);
				System.out.print(result);
			}
			DatabaseConnection.closeConnection(con, ps, rs);
			return result;
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String selectAll(int number) {
		String result = "";
		result += countCustomersPerBank(number);
		String sql = "SELECT * FROM customer WHERE bank_number = "+number;
		try {
			var con = DatabaseConnection.getConnection();
			var ps = con.prepareStatement(sql);
			var rs = ps.executeQuery();
			
			while (rs.next()) {
				int customerId = rs.getInt("customer_id");
				String customerName = rs.getString("customer_name");
				int bankNumber = rs.getInt("bank_number");
				double customerAmount = rs.getDouble("customer_amount");
				result += "%5d %10s %5d $5%.2f\n".formatted(customerId, customerName, bankNumber, customerAmount);
				System.out.print(result);
			}
			DatabaseConnection.closeConnection(con, ps, rs);
			return result;
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
