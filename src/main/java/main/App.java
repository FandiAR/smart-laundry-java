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

        // Login
        System.out.println("=== Login ===");
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (!userDAO.login(username, password)) {
            System.out.println("Login gagal! Username atau password salah.");
            return;
        }

        System.out.println("Login berhasil!");

        // Menu pilihan
        while (true) {
            System.out.println("\n=== Menu Utama ===");
            System.out.println("1. Input Data User");
            System.out.println("2. Input Data Customer");
            System.out.println("3. Input Data Order");
            System.out.println("4. Input Data Service");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Masukkan username baru: ");
                    String newUsername = scanner.nextLine();
                    System.out.print("Masukkan password baru: ");
                    String newPassword = scanner.nextLine();
                    userDAO.addUser(newUsername, newPassword);
                    break;
                case 2:
                    CustomerDAO customerDAO = new CustomerDAO();
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
                    System.out.print("Masukkan ID customer: ");
                    int customerId = scanner.nextInt();
                    System.out.print("Masukkan berat pakaian (kg): ");
                    double weight = scanner.nextDouble();
                    System.out.println("Pilih jenis layanan:");
                    System.out.println("1. Express (1 hari, 20000/kg)");
                    System.out.println("2. Business (2 hari, 15000/kg)");
                    System.out.println("3. Normal (3 hari, 10000/kg)");
                    int serviceChoice = scanner.nextInt();
                    int serviceId;
                    double pricePerKg;
                    LocalDate startDate = LocalDate.now();
                    LocalDate endDate;

                    if (serviceChoice == 1) {
                        serviceId = 1; // Express
                        pricePerKg = 20000.00;
                        endDate = startDate.plusDays(1);
                    } else if (serviceChoice == 2) {
                        serviceId = 2; // Business
                        pricePerKg = 15000.00;
                        endDate = startDate.plusDays(2);
                    } else {
                        serviceId = 3; // Normal
                        pricePerKg = 10000.00;
                        endDate = startDate.plusDays(3);
                    }
                    

                    orderDAO.insertOrder(customerId, weight, serviceId, startDate, endDate, pricePerKg);
                    break;
                case 4:
                    ServiceDAO serviceDAO = new ServiceDAO();
                    System.out.print("Masukkan nama layanan: ");
                    String serviceName = scanner.nextLine();
                    System.out.print("Masukkan harga per kilogram: ");
                    double basePrice = scanner.nextDouble();
                    serviceDAO.insertService(serviceName, basePrice);
                    break;
                case 5:
                    System.out.println("Keluar aplikasi...");
                    return;
                default:
                    System.out.println("Opsi tidak valid!");
            }
        }
    }
}
