package com.carsales;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class CarServiceTest {

    @Test
    public void testAddCar() {

        CarService service = new CarService();

        Car car =
                new Car(1, "Toyota", "Fortuner", 2025, 4200000);

        service.addCar(car);

        assertEquals(1, service.getCarCount());
    }

    @Test
    public void testFindCarById() {

        CarService service = new CarService();

        Car car =
                new Car(1, "Toyota", "Fortuner", 2025, 4200000);

        service.addCar(car);

        Car result =
                service.findCarById(1);

        assertNotNull(result);

        assertEquals("Toyota", result.getBrand());
        assertEquals("Fortuner", result.getModel());
        assertEquals(2025, result.getYear());
        assertEquals(4200000, result.getPrice(), 0.01);
    }

    @Test
    public void testFindNonExistingCar() {

        CarService service = new CarService();

        Car result =
                service.findCarById(100);

        assertNull(result);
    }

    @Test
    public void testSearchByBrand() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.addCar(
                new Car(2, "Toyota", "Innova", 2024, 2800000)
        );

        service.addCar(
                new Car(3, "BMW", "X1", 2024, 5200000)
        );

        List<Car> result =
                service.searchByBrand("Toyota");

        assertEquals(2, result.size());
    }

    @Test
    public void testSearchByBrandCaseInsensitive() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        List<Car> result =
                service.searchByBrand("toyota");

        assertEquals(1, result.size());
    }

    @Test
    public void testSearchByModel() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Hyundai", "Creta", 2025, 1800000)
        );

        service.addCar(
                new Car(2, "Hyundai", "Venue", 2025, 1400000)
        );

        List<Car> result =
                service.searchByModel("Creta");

        assertEquals(1, result.size());
        assertEquals("Creta", result.get(0).getModel());
    }

    @Test
    public void testSearchByMaxPrice() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.addCar(
                new Car(2, "Hyundai", "Creta", 2025, 1800000)
        );

        service.addCar(
                new Car(3, "Tata", "Nexon", 2025, 1500000)
        );

        List<Car> result =
                service.searchByMaxPrice(2000000);

        assertEquals(2, result.size());
    }

    @Test
    public void testBookCar() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        boolean result =
                service.bookCar(1);

        assertTrue(result);

        assertFalse(
                service.findCarById(1).isAvailable()
        );
    }

    @Test
    public void testCannotBookAlreadyBookedCar() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.bookCar(1);

        boolean result =
                service.bookCar(1);

        assertFalse(result);
    }

    @Test
    public void testBookNonExistingCar() {

        CarService service = new CarService();

        boolean result =
                service.bookCar(100);

        assertFalse(result);
    }

    @Test
    public void testCancelBooking() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.bookCar(1);

        boolean result =
                service.cancelBooking(1);

        assertTrue(result);

        assertTrue(
                service.findCarById(1).isAvailable()
        );
    }

    @Test
    public void testCannotCancelAvailableCar() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        boolean result =
                service.cancelBooking(1);

        assertFalse(result);
    }

    @Test
    public void testDeleteCar() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        boolean result =
                service.deleteCar(1);

        assertTrue(result);

        assertEquals(0, service.getCarCount());
    }

    @Test
    public void testDeleteNonExistingCar() {

        CarService service = new CarService();

        boolean result =
                service.deleteCar(100);

        assertFalse(result);
    }

    @Test
    public void testAvailableCarCount() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        service.addCar(
                new Car(2, "Hyundai", "Creta", 2025, 1800000)
        );

        service.bookCar(1);

        assertEquals(
                1,
                service.getAvailableCarCount()
        );
    }

    @Test
    public void testDuplicateCarId() {

        CarService service = new CarService();

        service.addCar(
                new Car(1, "Toyota", "Fortuner", 2025, 4200000)
        );

        try {

            service.addCar(
                    new Car(1, "BMW", "X1", 2024, 5200000)
            );

            fail("Expected IllegalArgumentException");

        } catch (IllegalArgumentException e) {

            assertEquals(
                    "Car ID already exists",
                    e.getMessage()
            );
        }
    }

    @Test
    public void testNullCar() {

        CarService service = new CarService();

        try {

            service.addCar(null);

            fail("Expected IllegalArgumentException");

        } catch (IllegalArgumentException e) {

            assertEquals(
                    "Car cannot be null",
                    e.getMessage()
            );
        }
    }
}