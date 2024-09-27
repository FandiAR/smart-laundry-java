package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import main.DatabaseConnection;
import main.Service;

public class ServiceDAO {
    public void insertService(String serviceName, double basePrice, int duration) {
        String query = "INSERT INTO services (service_name, base_price, duration) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, serviceName);
            stmt.setDouble(2, basePrice);
            stmt.setInt(3, duration);
            stmt.executeUpdate();
            System.out.println("========================================");
            System.out.println("Service berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Service getServiceById(int serviceId) {
        String query = "SELECT * FROM services WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, serviceId);
            var rs = stmt.executeQuery();
            if (rs.next()) {
                String serviceName = rs.getString("service_name");
                double basePrice = rs.getDouble("base_price");
                int duration = rs.getInt("duration");
                return new Service(serviceName, basePrice, duration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
