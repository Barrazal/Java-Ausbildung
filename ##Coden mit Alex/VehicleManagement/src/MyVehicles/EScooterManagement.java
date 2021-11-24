package MyVehicles;

import java.util.HashMap;
import java.util.Iterator;

public class EScooterManagement {
    private String name;
    private HashMap<String, ElectroScooter> scooterFleet; // All Scooters under Management
    private static Integer scooterCount = 0;

    public EScooterManagement(String name) {
        this.name = name;
        scooterFleet = new HashMap<>();
    }

    public void addScooter(ElectroScooter newScooter) {
        scooterFleet.put(newScooter.getId(), newScooter);
        scooterCount++;
    }

    public static Integer getScooterCount() {
        return scooterCount;
    }

    @Override
    public String toString() {
        StringBuilder fleetString = new StringBuilder();
        Iterator<ElectroScooter> iterator = scooterFleet.values().iterator();
        while (iterator.hasNext()) {
            fleetString.append(iterator.next() + "\n");
        }
        return "Management Branch: " + name + "\n" +
                "Scooter Fleet:\n" + fleetString;
    }
}