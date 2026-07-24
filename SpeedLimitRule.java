import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpeedLimitRule implements Rule {
    private final Map<CarType, Integer> limits;
    private final int fineAmount;

    public SpeedLimitRule(Map<CarType, Integer> limits, int fineAmount) {
        this.limits = limits;
        this.fineAmount = fineAmount;
    }

    @Override
    public List<Violation> evaluate(Observation obs) {
        List<Violation> violations = new ArrayList<>();
        Integer limit = limits.get(obs.getCarType());
        
        if (limit != null && obs.getSpeed() > limit) {
            String desc = "speed of " + obs.getSpeed() + " exceeded max allowed " + limit;
            violations.add(new Violation(desc, fineAmount, "SpeedLimitRule"));
        }
        return violations;
    }
}