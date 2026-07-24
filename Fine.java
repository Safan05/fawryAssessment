import java.util.List;
public class Fine {
    private String plateNumber;
    private int totalFee;
    private List<Violation> violations;

    public Fine(String plateNumber, int totalFee, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.totalFee = totalFee;
        this.violations = violations;
    }

    public String getPlateNumber() { return plateNumber; }
    public int getTotalFee() { return totalFee; }
    public List<Violation> getViolations() { return violations; }

    public void printFineDetails() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + totalFee + " EGP");
        System.out.println("Violations:");
        
        for (Violation v : violations) {
            System.out.println("- " + v.getDescription() + " : " + v.getFee() + " EGP");
        }
        System.out.println();
    }
}
