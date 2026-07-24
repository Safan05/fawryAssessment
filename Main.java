import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar();

        Map<CarType, Integer> speedLimits = new HashMap<>();
        speedLimits.put(CarType.TRUCK, 60);
        speedLimits.put(CarType.PRIVATE, 80);

        radar.addRule(new SpeedLimitRule(speedLimits, 300));
        radar.addRule(new SeatbeltRule(100)); 

        Observation obs1 = new Observation("ABC1234", new Date(), CarType.PRIVATE, 94, false);
        Observation obs2 = new Observation("XYZ9876", new Date(), CarType.TRUCK, 55, true); 
        Observation obs3 = new Observation("LMN4567", new Date(), CarType.TRUCK, 65, false);
        Observation obs4 = new Observation("ABC1234", new Date(), CarType.PRIVATE, 100, true); 

        radar.processObservation(obs1);
        radar.processObservation(obs2);
        radar.processObservation(obs3);
        radar.processObservation(obs4);

        System.out.println("-------------------------------------------------");
        
        System.out.println("All Possible Fines Aggregated:");
        Map<String, Integer> allFines = radar.getAllPossibleFines();
        for (Map.Entry<String, Integer> entry : allFines.entrySet()) {
            System.out.println("Plate: " + entry.getKey() + " | Total Outstanding: " + entry.getValue() + " EGP");
        }

        System.out.println("\n-------------------------------------------------");

        System.out.println("Violated Rules Statistics:");
        Map<String, Integer> ruleStats = radar.getAllViolatedRules();
        for (Map.Entry<String, Integer> entry : ruleStats.entrySet()) {
            System.out.println("Rule: " + entry.getKey() + " | Offenses: " + entry.getValue());
        }
    }
}