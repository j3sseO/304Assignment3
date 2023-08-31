// Name: Jesse OConnor
// ID: 1534760

import org.junit.jupiter.api.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class EmulationTest {
    
    @Test
    @DisplayName("Main emulation test with medium length message")
    public void emulationTestMainMedium() {
        String toTransmit = "10110111";
        String[] array = toTransmit.split("");
        assertDoesNotThrow(() -> Emulation.main(array));
    }

    @Test
    @DisplayName("Main emulation test with short length message")
    public void emulationTestMainShort() {
        String toTransmit = "10";
        String[] array = toTransmit.split("");
        assertDoesNotThrow(() -> Emulation.main(array));
    }

    @Test
    @DisplayName("Main emulation test with long length message")
    public void emulationTestMain() {
        String toTransmit = "1011011100010101010111101010110100101010101010100101010101010101011111110101010111101010100010101001010101";
        String[] array = toTransmit.split("");
        assertDoesNotThrow(() -> Emulation.main(array));
    }

}
