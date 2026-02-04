/**
 * Worker class represents an hourly worker
 * Inherits from Person
 */
public class Worker extends Person {

    // New field added by Worker
    private double hourlyPayRate;

    /**
     * Constructor for Worker
     * Calls the Person constructor using super()
     */
    public Worker(String ID, String firstName, String lastName, String title,
                  int YOB, double hourlyPayRate) {

        super(ID, firstName, lastName, title, YOB); // calls Person constructor
        this.hourlyPayRate = hourlyPayRate;
    }

    /**
     * Gets the hourly pay rate
     * @return hourly pay rate
     */
    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    /**
     * Calculates weekly pay including overtime
     * @param hoursWorked number of hours worked
     * @return total weekly pay
     */
    public double calculateWeeklyPay(double hoursWorked) {
        if (hoursWorked <= 40) {
            return hoursWorked * hourlyPayRate;
        } else {
            double regularPay = 40 * hourlyPayRate;
            double overtimeHours = hoursWorked - 40;
            double overtimePay = overtimeHours * hourlyPayRate * 1.5;
            return regularPay + overtimePay;
        }
    }

    /**
     * Displays weekly pay breakdown to the console
     */
    public void displayWeeklyPay(double hoursWorked) {
        double regularHours = Math.min(40, hoursWorked);
        double overtimeHours = Math.max(0, hoursWorked - 40);

        double regularPay = regularHours * hourlyPayRate;
        double overtimePay = overtimeHours * hourlyPayRate * 1.5;
        double totalPay = regularPay + overtimePay;

        System.out.println(
                formalName() +
                        " | Regular: " + regularHours + " hrs = $" + regularPay +
                        " | OT: " + overtimeHours + " hrs = $" + overtimePay +
                        " | Total: $" + totalPay
        );
    }

    /**
     * Overrides CSV output to include hourly pay rate
     */

    @Override
    public String toCSV() {
        return super.toCSV() + "," + hourlyPayRate;
    }

    /**
     * Overrides JSON output to include hourly pay rate
     */
    @Override
    public String toJSON() {
        return "{\n" +
                "  \"ID\": \"" + getID() + "\",\n" +
                "  \"firstName\": \"" + getFirstName() + "\",\n" +
                "  \"lastName\": \"" + getLastName() + "\",\n" +
                "  \"title\": \"" + getTitle() + "\",\n" +
                "  \"YOB\": " + getYOB() + ",\n" +
                "  \"hourlyPayRate\": " + hourlyPayRate + "\n" +
                "}";
    }

    /**
     * Overrides XML output to include hourly pay rate
     */
    @Override
    public String toXML() {
        return "<worker>\n" +
                "  <ID>" + getID() + "</ID>\n" +
                "  <firstName>" + getFirstName() + "</firstName>\n" +
                "  <lastName>" + getLastName() + "</lastName>\n" +
                "  <title>" + getTitle() + "</title>\n" +
                "  <YOB>" + getYOB() + "</YOB>\n" +
                "  <hourlyPayRate>" + hourlyPayRate + "</hourlyPayRate>\n" +
                "</worker>";
    }
}