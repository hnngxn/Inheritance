import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit tests for Worker
 */
class WorkerTest {

    private Worker w1;

    @BeforeEach
    void setUp() {
        // hourly rate = $20/hr
        w1 = new Worker("000002", "Amy", "Lee", "Ms.", 2000, 20.0);
    }

    @Test
    void calculateWeeklyPay_noOvertime_40Hours() {
        // 40 * 20 = 800
        assertEquals(800.0, w1.calculateWeeklyPay(40), 0.0001);
    }

    @Test
    void calculateWeeklyPay_withOvertime_50Hours() {
        // Regular: 40 * 20 = 800
        // OT: 10 * 20 * 1.5 = 300
        // Total: 1100
        assertEquals(1100.0, w1.calculateWeeklyPay(50), 0.0001);
    }

    @Test
    void calculateWeeklyPay_edgeCase_0Hours() {
        assertEquals(0.0, w1.calculateWeeklyPay(0), 0.0001);
    }

    @Test
    void toCSV_includesHourlyRate() {
        // Person CSV is: ID,first,last,title,YOB
        // Worker adds hourlyPayRate at the end
        String expected = "000002,Amy,Lee,Ms.,2000,20.0";
        assertEquals(expected, w1.toCSV());
    }

    @Test
    void toJSON_containsHourlyRateField() {
        String json = w1.toJSON();
        assertTrue(json.contains("\"hourlyPayRate\""));
        assertTrue(json.contains("20.0"));
    }

    @Test
    void toXML_containsHourlyRateTag() {
        String xml = w1.toXML();
        assertTrue(xml.contains("<hourlyPayRate>"));
        assertTrue(xml.contains("</hourlyPayRate>"));
    }
}
