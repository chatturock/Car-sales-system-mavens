package com.carsales;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        CarService service = new CarService();

        // Add cars to the system
        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.addCar(
                new Car(2, "Hyundai", "Creta", 2025, 1800000)
        );

        service.addCar(
                new Car(3, "Mahindra", "Scorpio", 2024, 2200000)
        );

        service.addCar(
                new Car(4, "Tata", "Nexon", 2025, 1500000)
        );

        service.addCar(
                new Car(5, "BMW", "X1", 2024, 5200000)
        );

        System.out.println("==========================================");
        System.out.println("           CAR SALES SYSTEM");
        System.out.println("==========================================");

        // Display all cars
        System.out.println("\n--- ALL CARS ---");

        for (Car car : service.getAllCars()) {
            System.out.println(car);
        }

        // Search by brand
        System.out.println("\n--- TOYOTA CARS ---");

        List<Car> toyotaCars =
                service.searchByBrand("Toyota");

        for (Car car : toyotaCars) {
            System.out.println(car);
        }

        // Search by model
        System.out.println("\n--- CRETA CARS ---");

        List<Car> cretaCars =
                service.searchByModel("Creta");

        for (Car car : cretaCars) {
            System.out.println(car);
        }

        // Search by price
        System.out.println("\n--- CARS BELOW ₹20,00,000 ---");

        List<Car> affordableCars =
                service.searchByMaxPrice(2000000);

        for (Car car : affordableCars) {
            System.out.println(car);
        }

        // Display available cars
        System.out.println("\n--- AVAILABLE CARS ---");

        for (Car car : service.getAvailableCars()) {
            System.out.println(car);
        }

        // Book car
        System.out.println("\n--- BOOKING CAR ID 2 ---");

        boolean booked = service.bookCar(2);

        if (booked) {
            System.out.println("Car booked successfully.");
        } else {
            System.out.println("Car booking failed.");
        }

        // Display booked car
        System.out.println("\nUpdated Car:");

        Car bookedCar = service.findCarById(2);

        if (bookedCar != null) {
            System.out.println(bookedCar);
        }

        // Try booking same car again
        System.out.println("\n--- BOOKING CAR ID 2 AGAIN ---");

        boolean secondBooking = service.bookCar(2);

        if (secondBooking) {
            System.out.println("Car booked successfully.");
        } else {
            System.out.println("Car is already booked.");
        }

        // Cancel booking
        System.out.println("\n--- CANCELLING BOOKING ---");

        boolean cancelled =
                service.cancelBooking(2);

        if (cancelled) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Cancellation failed.");
        }

        // Final statistics
        System.out.println("\n--- SYSTEM SUMMARY ---");

        System.out.println(
                "Total Cars: " + service.getCarCount()
        );

        System.out.println(
                "Available Cars: " + service.getAvailableCarCount()
        );

        System.out.println("\n==========================================");
        System.out.println("        PROGRAM COMPLETED");
        System.out.println("==========================================");
    }
}