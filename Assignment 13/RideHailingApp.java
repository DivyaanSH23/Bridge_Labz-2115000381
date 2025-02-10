import java.util.Random;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per km: $" + ratePerKm;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Unknown";
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

class RideService {
    public static void calculateFareForRide(Vehicle vehicle, double distance) {
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Total Fare for " + distance + " km: $" + vehicle.calculateFare(distance));

        if (vehicle instanceof GPS) {
            GPS gps = (GPS) vehicle;
            gps.updateLocation("Destination Reached");
            System.out.println("Updated Location: " + gps.getCurrentLocation());
        }

        System.out.println("--------------------------------------");
    }
}

public class RideHailingApp {
    public static void main(String[] args) {
        Vehicle car = new Car("C1001", "John Doe", 10.0);
        Vehicle bike = new Bike("B2001", "Jane Smith", 5.0);
        Vehicle auto = new Auto("A3001", "Mike Johnson", 7.0);

        RideService.calculateFareForRide(car, 15);
        RideService.calculateFareForRide(bike, 10);
        RideService.calculateFareForRide(auto, 12);
    }
}
