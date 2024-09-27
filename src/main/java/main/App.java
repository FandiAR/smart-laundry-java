package main;

import java.util.Scanner;

import dao.CustomerDAO;
import dao.LaundryOrderDAO;
import dao.ServiceDAO;
import dao.UserDAO;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO = new UserDAO();
        ServiceDAO serviceDAO = new ServiceDAO();

        // Login
        System.out.println("=== Login ===");
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (!userDAO.login(username, password)) {
            System.out.println("========================================");
            System.out.println("Login gagal! Username atau password salah.");
            return;
        }

        System.out.println("========================================");
        System.out.println("Login berhasil!");

        // Menu pilihan
        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Input Data User");
            System.out.println("2. Input Data Customer");
            System.out.println("3. Input Data Order");
            System.out.println("4. Input Data Service");
            System.out.println("5. Keluar");
            System.out.println("========================================");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("========================================");
                    System.out.print("Masukkan username baru: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String newPassword = scanner.nextLine();
                    userDAO.addUser(newUsername, newPassword);
                    break;
                case 2:
                    CustomerDAO customerDAO = new CustomerDAO();
                    System.out.println("========================================");
                    System.out.print("Masukkan nama customer: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Masukkan nomor telepon customer: ");
                    String phone = scanner.nextLine();
                    System.out.print("Masukkan email customer (optional): ");
                    String email = scanner.nextLine();
                    customerDAO.insertCustomer(customerName, phone, email);
                    break;
                case 3:
                    LaundryOrderDAO orderDAO = new LaundryOrderDAO();
                    System.out.println("========================================");
                    System.out.print("Masukkan ID customer: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Masukkan berat pakaian (kg): ");
                    double weight = scanner.nextDouble();
                    System.out.print("Masukkan ID layanan: ");
                    int serviceId = scanner.nextInt();
                    
                    LocalDate startDate = LocalDate.now();
                    orderDAO.insertOrder(customerId, weight, serviceId, startDate);
                    break;
                case 4:
                    System.out.println("========================================");
                    System.out.print("Masukkan nama layanan: ");
                    String serviceName = scanner.nextLine();
                    System.out.print("Masukkan harga per kilogram: ");
                    double basePrice = scanner.nextDouble();
                    System.out.print("Masukkan durasi layanan (hari): ");
                    int duration = scanner.nextInt();
                    serviceDAO.insertService(serviceName, basePrice, duration);
                    break;
                case 5:
                    System.out.println("========================================");
                    System.out.println("Keluar aplikasi...");
                    return;
                default:
                    System.out.println("========================================");
                    System.out.println("Opsi tidak valid!");
            }
        }
    }
}
