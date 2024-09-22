package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DatabaseConnection;
import main.Service;

public class ServiceDAO {
    public void insertService(String serviceName, double basePrice) {
        String query = "INSERT INTO services (service_name, base_price) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, serviceName);
            stmt.setDouble(2, basePrice);
            stmt.executeUpdate();
            System.out.println("Service berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
