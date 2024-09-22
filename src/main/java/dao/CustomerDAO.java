package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.Customer;
import main.DatabaseConnection;

public class CustomerDAO {
    public void insertCustomer(String name, String phone, String email) {
        String query = "INSERT INTO customers (name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("Customer berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
