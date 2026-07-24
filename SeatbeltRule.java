import java.util.ArrayList;
import java.util.List;

public class SeatbeltRule implements Rule {
    private final int fineAmount;

    public SeatbeltRule(int fineAmount) {
        this.fineAmount = fineAmount;
    }

    @Override
    public List<Violation> evaluate(Observation obs) {
        List<Violation> violations = new ArrayList<>();
        if (!obs.isSeatbeltFastened()) {
            violations.add(new Violation("Seatbelt not fastned ", fineAmount, "SeatbeltRule"));
        }
        return violations;
    }
}