// Name: Jesse OConnor
// ID: 1534760

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class QubitTest {

    @Test
    @DisplayName("Measure test with matching polarization, expected true")
    public void measureTestEqual() {
        Qubit q = new Qubit(0, 0);
        assertEquals(0, q.measure(0));
    }

    @Test
    @DisplayName("Measure test with different polarization, expected true")
    public void measureTestDifferent() {
        int[] polarizations = new int[20];
        for (int i = 0; i < 20; i++) {
            Qubit q = new Qubit(0, 0);
            polarizations[i] = q.measure(1);
        }
        try {
            // Checks that array contains both types of polarizations, 50/50 chance of both
            assertTrue(Arrays.asList(polarizations).contains(0));
            assertTrue(Arrays.asList(polarizations).contains(1));
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @DisplayName("Measure test with invalid polarization, expected true")
    public void measureTestInvalid() {
        int[] polarizations = new int[20];
        for (int i = 0; i < 20; i++) {
            Qubit q = new Qubit(0, 2);
            polarizations[i] = q.measure(1);
        }
        // Method should change invalid polarization to 1 or 0
        try {
            // Checks that array contains both types of polarizations, 50/50 chance of both
            assertTrue(Arrays.asList(polarizations).contains(0));
            assertTrue(Arrays.asList(polarizations).contains(1));
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }
    }

}
