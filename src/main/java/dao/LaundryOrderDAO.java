package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import main.DatabaseConnection;
import main.LaundryOrder;

public class LaundryOrderDAO {
    public void insertOrder(int customerId, double weight, int serviceId, LocalDate startDate, LocalDate endDate, double pricePerKg) {
        String query = "INSERT INTO laundry_orders (customer_id, weight, service_id, total_price, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
        double totalPrice = weight * pricePerKg;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, customerId);
            stmt.setDouble(2, weight);
            stmt.setInt(3, serviceId);
            stmt.setDouble(4, totalPrice);
            stmt.setString(5, "In Progress");
            stmt.setObject(6, startDate);
            stmt.setObject(7, endDate);
            stmt.executeUpdate();
            System.out.println("Order berhasil ditambahkan dengan tanggal mulai " + startDate + " dan selesai " + endDate);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
