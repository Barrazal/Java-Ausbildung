package MyVehicles;

public class VehicleTestbench {
    public static void main(String[] args) {
        ElectroScooter myScooter = new ElectroScooter();

        myScooter.setMileage(2000);
        System.out.println(myScooter.getMileage());

        myScooter.setMileage(1000);
        System.out.println(myScooter.getMileage());

        myScooter.setMileage(1000, true);
        System.out.println(myScooter);

        EScooterManagement codersBayScooters = new EScooterManagement("CodersBay Scooters");
        codersBayScooters.addScooter(myScooter);
        codersBayScooters.addScooter(new ElectroScooter("CBS0002", 50.0, 0, 1000.50, 150, ScooterBrand.FERRARI));

        EScooterManagement viennaScooters = new EScooterManagement("Vienna Scooters");
        viennaScooters.addScooter(new ElectroScooter());
        viennaScooters.addScooter(new ElectroScooter("VIS0002", 20.0, 0, 50.50, 45, ScooterBrand.BUGATTI));

        ElectroScooter scooter3 = new ElectroScooter();

        System.out.println("Number of total Scooters Managed: " + EScooterManagement.getScooterCount());
        System.out.println("Number of total Scooters: " + ElectroScooter.getCounter());

        System.out.println(codersBayScooters);
        System.out.println(viennaScooters);
    }
}
