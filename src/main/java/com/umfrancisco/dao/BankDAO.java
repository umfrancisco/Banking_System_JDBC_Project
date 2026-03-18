package com.umfrancisco.dao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import com.umfrancisco.domain.Bank;
import com.umfrancisco.domain.Customer;
import com.umfrancisco.util.DatabaseConnection;

public class BankDAO {
	
	public void add(Customer customer, Bank bank) {
		String sql = "INSERT INTO customer(customer_id, customer_name, bank_number, customer_amount) VALUES (?,?,?,?)";
		var con = DatabaseConnection.getConnection();
		try {
			var ps = con.prepareStatement(sql);
			ps.setInt(1, customer.id());
			ps.setString(2, customer.name());
			ps.setInt(3, bank.bankNumber());
			ps.setDouble(4, customer.amount());
			ps.execute();
			System.out.println(LocalDateTime.now()+": "+sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
