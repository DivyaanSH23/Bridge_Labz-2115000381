class Vehical {
    private static double registrationFee = 500.0;
    private String ownerName;
    private String vehicleType;
    private final String registrationNumber;

    public Vehical(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayDetails() {
        if (this instanceof Vehical) {
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Reg No: " + registrationNumber);
            System.out.println("Fee: " + registrationFee);
        }
    }

    public static void main(String[] args) {
        Vehical v1 = new Vehical("John Doe", "Car", "ABC123");
        Vehical v2 = new Vehical("Jane Smith", "Bike", "XYZ789");
        v1.displayDetails();
        v2.displayDetails();
        updateRegistrationFee(600.0);
        v1.displayDetails();
        v2.displayDetails();
    }
}
