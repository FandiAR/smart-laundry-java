package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import main.DatabaseConnection;
import main.LaundryOrder;
import main.Service;

import utils.CurrencyFormatter;

public class LaundryOrderDAO {
    private ServiceDAO serviceDAO = new ServiceDAO();

    public void insertOrder(int customerId, double weight, int serviceId, LocalDate startDate) {
        // Ambil data service berdasarkan serviceId
        Service service = serviceDAO.getServiceById(serviceId);
        if (service == null) {
            System.out.println("====================");
            System.out.println("Service tidak ditemukan.");
            return;
        }

        // Hitung total price dan endDate berdasarkan duration dari service
        double totalPrice = weight * service.getBasePrice();
        LocalDate endDate = startDate.plusDays(service.getDuration());

        String query = "INSERT INTO laundry_orders (customer_id, weight, service_id, total_price, status, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

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

            String totalPriceFormatted = CurrencyFormatter.convertToRupiah(totalPrice);
            System.out.println("====================");
            System.out.println("Order berhasil ditambahkan dengan tanggal mulai " + startDate + " dan selesai " + endDate);
            System.out.println("====================");
            System.out.println("Total harga = " + totalPriceFormatted);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
