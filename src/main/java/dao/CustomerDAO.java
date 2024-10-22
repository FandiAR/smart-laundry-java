package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import main.Customer;
import main.DatabaseConnection;

public class CustomerDAO {
    public Customer getCustomerById(int customerId) {
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

     // Method untuk mencetak detail customer dengan Method Reference
    public void printCustomerDetails(Customer customer) {
        // Menggunakan Method Reference
        System.out.println("Nama: " + customer.getName());
        System.out.println("Telepon: " + customer.getPhone());
        System.out.println("Email: " + customer.getEmail());
    }

    public void insertCustomer(Customer customer) {
        if (customer.getName() == null || customer.getName().trim().isEmpty()) {
            System.out.println("========================================");
            System.out.println("Error: Nama customer tidak boleh kosong.");
            return;
        } else if (customer.getPhone() == null || customer.getPhone().trim().isEmpty()) {
            System.out.println("========================================");
            System.out.println("Error: Nomor telepon customer tidak boleh kosong.");
            return;
        }

        String query = "INSERT INTO customers (name, phone, email) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, customer.getName());
            stmt.setString(2, customer.getPhone());
            stmt.setString(3, customer.getEmail());
            stmt.executeUpdate();
            System.out.println("========================================");
            System.out.println("Customer berhasil ditambahkan.");
            printCustomerDetails(customer);  // Method Reference
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
