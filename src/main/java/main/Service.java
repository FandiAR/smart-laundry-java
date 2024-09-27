package main;

public class Service {
    private int id;
    private String serviceName;
    private double basePrice;
    private int duration;

    public Service(String serviceName, double basePrice, int duration) {
        this.serviceName = serviceName;
        this.basePrice = basePrice;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setBasePrice(double basePrice) {
      this.basePrice = basePrice;
    }

    public double getBasePrice() {
      return basePrice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

