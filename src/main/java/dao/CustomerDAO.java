package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import main.Customer;
import main.DatabaseConnection;

public class CustomerDAO {
    public Customer getId(int customerId) {
        String query = "SELECT * FROM customers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("phone"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertCustomer(String name, String phone, String email) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("========================================");
            System.out.println("Error: Nama customer tidak boleh kosong.");
            return;
        } else if (phone == null || phone.trim().isEmpty()) {
            System.out.println("========================================");
            System.out.println("Error: Nomor telepon customer tidak boleh kosong.");
            return;
        }

        String query = "INSERT INTO customers (name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, phone);
            stmt.setString(3, email);
            stmt.executeUpdate();
            System.out.println("========================================");
            System.out.println("Customer berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
