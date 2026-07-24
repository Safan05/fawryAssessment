import java.util.List;

public interface Rule {
    List<Violation> evaluate(Observation obs);
}
