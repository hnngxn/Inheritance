/**
 * SalaryWorker represents a worker paid by annual salary.
 * Inherits from Worker.
 */
public class SalaryWorker extends Worker {

    private double annualSalary;

    /**
     * Constructor for SalaryWorker
     * Uses super() to call Worker constructor
     */
    public SalaryWorker(String ID, String firstName, String lastName, String title,
                        int YOB, double hourlyPayRate, double annualSalary) {

        super(ID, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    /**
     * Weekly pay is annualSalary / 52.
     * hoursWorked is ignored but kept for polymorphism.
     */
    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary / 52.0;
    }

    /**
     * Display that weekly pay is based on salary.
     */
    @Override
    public void displayWeeklyPay(double hoursWorked) {
        double weeklyPay = calculateWeeklyPay(hoursWorked);
        System.out.println(
                formalName() +
                        " | Salary: $" + annualSalary +
                        " / 52 = Weekly Pay $" + weeklyPay
        );
    }

    /**
     * Overrides CSV output to include annual salary too
     * Format: PersonCSV + hourlyRate + annualSalary
     */
    @Override
    public String toCSV() {
        return super.toCSV() + "," + annualSalary;
    }

    @Override
    public String toJSON() {
        return "{\n" +
                "  \"ID\": \"" + getID() + "\",\n" +
                "  \"firstName\": \"" + getFirstName() + "\",\n" +
                "  \"lastName\": \"" + getLastName() + "\",\n" +
                "  \"title\": \"" + getTitle() + "\",\n" +
                "  \"YOB\": " + getYOB() + ",\n" +
                "  \"hourlyPayRate\": " + getHourlyPayRate() + ",\n" +
                "  \"annualSalary\": " + annualSalary + "\n" +
                "}";
    }

    @Override
    public String toXML() {
        return "<salaryWorker>\n" +
                "  <ID>" + getID() + "</ID>\n" +
                "  <firstName>" + getFirstName() + "</firstName>\n" +
                "  <lastName>" + getLastName() + "</lastName>\n" +
                "  <title>" + getTitle() + "</title>\n" +
                "  <YOB>" + getYOB() + "</YOB>\n" +
                "  <hourlyPayRate>" + getHourlyPayRate() + "</hourlyPayRate>\n" +
                "  <annualSalary>" + annualSalary + "</annualSalary>\n" +
                "</salaryWorker>";
    }
}
