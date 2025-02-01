class Vehicle {
    String ownerName;
    String vehicleType;
    static double registrationFee = 500.0;

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
}

public class Mains {
    public static void main(String[] args) {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.ownerName = "John Doe";
        vehicle1.vehicleType = "Car";

        Vehicle vehicle2 = new Vehicle();
        vehicle2.ownerName = "Jane Smith";
        vehicle2.vehicleType = "Motorcycle";

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();

        System.out.println("\nUpdating registration fee...\n");
        Vehicle.updateRegistrationFee(600.0);

        vehicle1.displayVehicleDetails();
        vehicle2.displayVehicleDetails();
    }
}
