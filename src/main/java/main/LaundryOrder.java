package main;

import java.time.LocalDate;

public class LaundryOrder {
    private int id;
    private int customerId;
    private double weight;
    private int serviceId;
    private double totalPrice;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;

    public LaundryOrder(int customerId, double weight, int serviceId, LocalDate startDate, LocalDate endDate) {
        this.customerId = customerId;
        this.weight = weight;
        this.serviceId = serviceId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "In Progress";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
