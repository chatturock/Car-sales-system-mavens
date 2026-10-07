# Car Sales System

A Java-based Car Sales System developed using Maven.

## Features

- Add cars
- Find car by ID
- Search cars by brand
- Search cars by model
- Search cars by maximum price
- Display available cars
- Book a car
- Cancel booking
- Delete a car
- Count total cars
- Count available cars

## Technologies

- Java 17
- Maven
- JUnit 4
- Jenkins
- GitHub

## Project Structure

Car-Sales-System/
│
├── pom.xml
├── Jenkinsfile
│
└── src/
    ├── main/
    │   └── java/
    │       └── com/
    │           └── carsales/
    │               ├── Car.java
    │               ├── CarService.java
    │               └── Main.java
    │
    └── test/
        └── java/
            └── com/
                └── carsales/
                    └── CarServiceTest.java

## Run the Project

Compile:

mvn compile

Run tests:

mvn test

Clean and test:

mvn clean test

Create package:

mvn package

## Jenkins

The Jenkins pipeline performs:

1. Checkout source code
2. Maven clean
3. Compile Java code
4. Run JUnit tests
5. Create Maven package

If all stages are successful, Jenkins displays:

BUILD SUCCESS