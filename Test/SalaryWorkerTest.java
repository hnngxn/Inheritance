import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for SalaryWorker
 */
class SalaryWorkerTest {

    private SalaryWorker sw;

    @BeforeEach
    void setUp() {
        // Annual salary = $52,000 → weekly = $1,000
        sw = new SalaryWorker(
                "000003",
                "Sara",
                "Kim",
                "Dr.",
                1985,
                30.0,       // hourly rate (not used for pay, but required by constructor)
                52000.0     // annual salary
        );
    }

    @Test
    void calculateWeeklyPay_ignoresHoursWorked() {
        // No matter the hours, weekly pay is salary / 52
        assertEquals(1000.0, sw.calculateWeeklyPay(40), 0.0001);
        assertEquals(1000.0, sw.calculateWeeklyPay(50), 0.0001);
        assertEquals(1000.0, sw.calculateWeeklyPay(10), 0.0001);
    }

    @Test
    void toCSV_includesAnnualSalary() {
        String expected = "000003,Sara,Kim,Dr.,1985,30.0,52000.0";
        assertEquals(expected, sw.toCSV());
    }

    @Test
    void toJSON_containsAnnualSalaryField() {
        String json = sw.toJSON();
        assertTrue(json.contains("\"annualSalary\""));
        assertTrue(json.contains("52000.0"));
    }

    @Test
    void toXML_containsAnnualSalaryTag() {
        String xml = sw.toXML();
        assertTrue(xml.contains("<annualSalary>"));
        assertTrue(xml.contains("</annualSalary>"));
    }
}
