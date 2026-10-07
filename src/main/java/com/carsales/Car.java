package com.carsales;

public class Car {

    private int id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private boolean available;

    public Car(int id, String brand, String model, int year, double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.available = true;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d | %s %s | Year: %d | Price: ₹%.2f | %s",
                id,
                brand,
                model,
                year,
                price,
                available ? "Available" : "Booked"
        );
    }
}