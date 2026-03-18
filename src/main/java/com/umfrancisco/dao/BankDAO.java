package com.umfrancisco.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import com.umfrancisco.domain.Bank;
import com.umfrancisco.domain.Customer;
import com.umfrancisco.util.DatabaseConnection;

public class BankDAO {
	
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
	
	public void selectAll(int number) {
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
				System.out.println("%5d %10s %5d $5%.2f".formatted(customerId, customerName, bankNumber, customerAmount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
