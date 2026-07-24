public class Violation {
    private String description;
    private int fee;
    private String ruleName;

    public Violation(String description, int fee, String ruleName) {
        this.description = description;
        this.fee = fee;
        this.ruleName = ruleName;
    }

    public String getDescription() { return description; }
    public int getFee() { return fee; }
    public String getRuleName() { return ruleName; }
}
