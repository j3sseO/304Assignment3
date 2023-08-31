// Name: Jesse OConnor
// ID: 1534760

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import org.junit.jupiter.api.*;
import static org.junit.Assert.*;

public class XORTest {
    
    @Test
    @DisplayName("isCorrectFormat test with valid format, expected true")
    public void isCorrectFormatTestValid() {
        assertDoesNotThrow(() -> XOR.isCorrectFormat("1011 "));
    }

    @Test
    @DisplayName("isCorrectFormat test with invalid format, expected true")
    public void isCorrectFormatInvalid() {
        assertThrows(Exception.class, () -> XOR.isCorrectFormat("1001 2011"));
    }

    @Test
    @DisplayName("keyToLength test with short key, expected true")
    public void keyToLengthShort() {
        XOR xor = new XOR("1011");
        assertEquals("10111011", xor.keyToLength(5));
    }

    @Test
    @DisplayName("keyToLength test with long key, expected true")
    public void keyToLengthLong() {
        XOR xor = new XOR("1011");
        assertEquals("1011", xor.keyToLength(3));
    }

    @Test
    @DisplayName("xorMessage test encode, expected true")
    public void xorMessageEncode() {
        XOR xor = new XOR("1011");
        assertEquals("000011110111",xor.xorMessage("101101001100"));
    }

    @Test
    @DisplayName("xorMessage test decode, expected true")
    public void xorMessageDecode() {
        XOR xor = new XOR("1011");
        assertEquals("101101001100", xor.xorMessage("000011110111"));
    }

    @Test
    @DisplayName("xorMessage test with long key, expected true")
    public void xorMessageLongKey() {
        XOR xor = new XOR("10110110");
        assertEquals("000", xor.xorMessage("101"));
    }
}
