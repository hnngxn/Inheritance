import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for Person
 */

class PersonTest {

    private Person testPerson;

    @BeforeEach
    void setUp() {
        // Create a test person before each test
        testPerson = new Person("000001", "John", "Doe", "Mr.", 1990);
    }

    @Test
    void setFirstName() {
        testPerson.setFirstName("Jane");
        assertEquals("Jane", testPerson.getFirstName());
    }

    @Test
    void setLastName() {
        testPerson.setLastName("Smith");
        assertEquals("Smith", testPerson.getLastName());
    }

    @Test
    void setTitle() {
        testPerson.setTitle("Dr.");
        assertEquals("Dr.", testPerson.getTitle());
    }

    @Test
    void setYOB() {
        testPerson.setYOB(1985);
        assertEquals(1985, testPerson.getYOB());
    }

    @Test
    void fullName() {
        assertEquals("John Doe", testPerson.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr. John Doe", testPerson.formalName());
    }

    @Test
    void getAge() {
        assertEquals("34", testPerson.getAge()); // 2024 - 1990 = 34
    }

    @Test
    void testGetAgeWithYear() {
        assertEquals("30", testPerson.getAge(2020)); // 2020 - 1990 = 30
    }

    @Test
    void toCSVDataRecord() {
        String expected = "000001,John,Doe,Mr.,1990";
        assertEquals(expected, testPerson.toCSVDataRecord());
    }

    @Test
    void toJSON() {
        String expected = "{\n" +
                "  \"ID\": \"000001\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"title\": \"Mr.\",\n" +
                "  \"YOB\": 1990\n" +
                "}";
        assertEquals(expected, testPerson.toJSON());
    }

    @Test
    void toXML() {
        String expected = "<person>\n" +
                "  <ID>000001</ID>\n" +
                "  <firstName>John</firstName>\n" +
                "  <lastName>Doe</lastName>\n" +
                "  <title>Mr.</title>\n" +
                "  <YOB>1990</YOB>\n" +
                "</person>";
        assertEquals(expected, testPerson.toXML());
    }
}