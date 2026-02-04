/**
 * Person class represents a person with ID, names, title, and year of birth
 * @author Han Nguyen
 */
public class Person {
    // Private fields - the data each Person object stores
    private String ID;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    /**
     * Constructor - creates a new Person object with all fields
     * @param ID - unique identifier
     * @param firstName - person's first name
     * @param lastName - person's last name
     * @param title - person's title (Mr., Mrs., Dr., etc.)
     * @param YOB - year of birth (1940-2010)
     */
    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    // GETTERS - methods to read the private fields
    /**
     * Gets the ID
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the year of birth
     * @return the year of birth
     */
    public int getYOB() {
        return YOB;
    }

    // SETTERS - methods to change the private fields

    /**
     * Sets the first name
     * @param firstName the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name
     * @param lastName the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the title
     * @param title the new title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the year of birth
     * @param YOB the new year of birth
     */
    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    // SPECIAL METHODS - custom methods for this class

    /**
     * Returns the full name (first + last)
     * @return full name as "FirstName LastName"
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name (title + first + last)
     * @return formal name as "Title FirstName LastName"
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Calculates age in current year (2024)
     * @return current age as a String
     */
    public String getAge() {
        int age = 2024 - YOB;
        return String.valueOf(age);
    }

    /**
     * Calculates age in a specific year
     * @param year the year to calculate age for
     * @return age in that year as a String
     */
    public String getAge(int year) {
        int age = year - YOB;
        return String.valueOf(age);
    }

    /**
     * Converts person data to CSV format
     * @return CSV string: "ID,firstName,lastName,title,YOB"
     */
    public String toCSVDataRecord() {
        return ID + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    public String toCSV() {
        return toCSVDataRecord();
    }

    /**
     * Converts person data to JSON format
     * @return JSON string representation
     */
    public String toJSON() {
        return "{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}";
    }

    /**
     * Converts person data to XML format
     * @return XML string representation
     */
    public String toXML() {
        return "<person>\n" +
                "  <ID>" + ID + "</ID>\n" +
                "  <firstName>" + firstName + "</firstName>\n" +
                "  <lastName>" + lastName + "</lastName>\n" +
                "  <title>" + title + "</title>\n" +
                "  <YOB>" + YOB + "</YOB>\n" +
                "</person>";
    }
}