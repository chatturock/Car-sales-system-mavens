package com.carsales;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    private final List<Car> cars;

    public CarService() {
        cars = new ArrayList<>();
    }

    // Add a car
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("Car cannot be null");
        }

        if (findCarById(car.getId()) != null) {
            throw new IllegalArgumentException("Car ID already exists");
        }

        cars.add(car);
    }

    // Get all cars
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    // Find car by ID
    public Car findCarById(int id) {

        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }

    // Search cars by brand
    public List<Car> searchByBrand(String brand) {

        List<Car> result = new ArrayList<>();

        if (brand == null) {
            return result;
        }

        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                result.add(car);
            }
        }

        return result;
    }

    // Search cars by model
    public List<Car> searchByModel(String model) {

        List<Car> result = new ArrayList<>();

        if (model == null) {
            return result;
        }

        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                result.add(car);
            }
        }

        return result;
    }

    // Search cars below maximum price
    public List<Car> searchByMaxPrice(double maxPrice) {

        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPrice() <= maxPrice && car.isAvailable()) {
                result.add(car);
            }
        }

        return result;
    }

    // Get only available cars
    public List<Car> getAvailableCars() {

        List<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (car.isAvailable()) {
                result.add(car);
            }
        }

        return result;
    }

    // Book a car
    public boolean bookCar(int id) {

        Car car = findCarById(id);

        if (car != null && car.isAvailable()) {
            car.setAvailable(false);
            return true;
        }

        return false;
    }

    // Cancel booking
    public boolean cancelBooking(int id) {

        Car car = findCarById(id);

        if (car != null && !car.isAvailable()) {
            car.setAvailable(true);
            return true;
        }

        return false;
    }

    // Delete a car
    public boolean deleteCar(int id) {

        Car car = findCarById(id);

        if (car != null) {
            cars.remove(car);
            return true;
        }

        return false;
    }

    // Count total cars
    public int getCarCount() {
        return cars.size();
    }

    // Count available cars
    public int getAvailableCarCount() {

        int count = 0;

        for (Car car : cars) {
            if (car.isAvailable()) {
                count++;
            }
        }

        return count;
    }
}