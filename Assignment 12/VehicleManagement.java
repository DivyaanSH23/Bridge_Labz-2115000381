import java.util.*;

class Vehicle {
    String model;
    int maxSpeed;
    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    void display() {
        System.out.println("Model: " + model + ", Max Speed: " + maxSpeed);
    }
}

interface Refuelable {
    void refuel();
}

class ElectricVehicle extends Vehicle {
    ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    void charge() {
        System.out.println(model + " is charging.");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }
    public void refuel() {
        System.out.println(model + " is refueling.");
    }
}

public class VehicleManagement {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new ElectricVehicle("Tesla Model S", 200));
        vehicles.add(new PetrolVehicle("Ford Mustang", 250));
        for (Vehicle vehicle : vehicles) {
            vehicle.display();
            if (vehicle instanceof ElectricVehicle) {
                ((ElectricVehicle) vehicle).charge();
            } else if (vehicle instanceof PetrolVehicle) {
                ((PetrolVehicle) vehicle).refuel();
            }
        }
    }
}
