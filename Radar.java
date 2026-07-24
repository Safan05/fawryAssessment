import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Radar {
    private final List<Rule> rules;
    private final List<Fine> issuedFines;
    private final Map<String, Integer> ruleViolationCounts;

    public Radar() {
        this.rules = new ArrayList<>();
        this.issuedFines = new ArrayList<>();
        this.ruleViolationCounts = new HashMap<>();
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void processObservation(Observation obs) {
        List<Violation> currentViolations = new ArrayList<>();
        int totalFineAmount = 0;

        for (Rule rule : rules) {
            List<Violation> violations = rule.evaluate(obs);
            for (Violation v : violations) {
                currentViolations.add(v);
                totalFineAmount += v.getFee();
                
                ruleViolationCounts.put(
                    v.getRuleName(), 
                    ruleViolationCounts.getOrDefault(v.getRuleName(), 0) + 1
                );
            }
        }

        if (!currentViolations.isEmpty()) {
            Fine fine = new Fine(obs.getPlateNumber(), totalFineAmount, currentViolations);
            issuedFines.add(fine);
            fine.printFineDetails();
        }
    }

    public Map<String, Integer> getAllPossibleFines() {
        Map<String, Integer> finesMap = new HashMap<>();
        for (Fine fine : issuedFines) {
            finesMap.put(
                fine.getPlateNumber(), 
                finesMap.getOrDefault(fine.getPlateNumber(), 0) + fine.getTotalFee()
            );
        }
        return finesMap;
    }

    public Map<String, Integer> getAllViolatedRules() {
        return ruleViolationCounts;
    }
}