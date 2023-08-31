// Name: Jesse OConnor
// ID: 1534760

import java.util.Set;

/**
 * XOR class
 * Holds key to encode/decode with, makes sure key and value to encode is in correct format,
 * also encode/decodes values
 */
public class XOR {
    
    // Encode/decode string
    private String key;
    
    /**
     * XOR constructor method
     * Checks that key is in correct format, then initialises key
     * @param key Key to encode/decode with
     */
    public XOR(String key) {
        isCorrectFormat(key);
        this.key = key;
    }
    
    /**
     * setKey method that changes the key value
     * @param key Value to change key to
     */
    public void setKey(String key) {
        isCorrectFormat(key);
        this.key = key;
    }
    
    /**
     * isCorrectFormat method checks if the string parameter is made up of 0's, 1's and " "'s only
     * @param entry String to check format of
     */
    public static void isCorrectFormat(String entry) {
        // Creates set of valid characters entry can contain
        Set<String> validCharacters = Set.of("0", "1", " ");
        
        // Loops through entry checking each character is valid
        for (char c : entry.toCharArray()) {
            if (!validCharacters.contains(String.valueOf(c))) {
                throw new IllegalArgumentException("Invalid character... please remove the found " + c);
            }
        }
    }
    
    /**
     * keyToLength method appends key to itself to ensure it is long enough for xor usage
     * @param requiredLength Minimum required length our key must be before usage
     * @return Altered length key, still outputs same results when encoding/decoding
     */
    public String keyToLength(int requiredLength) {
        StringBuilder sb = new StringBuilder();

        int initialKeyLength = key.length();
        sb.append(key);

        for (int i = initialKeyLength; i < requiredLength; i++) {
            sb.append(key);
        }

        return sb.toString();
    }

    /**
     * xorMessage method that XORs string parameter
     * @param message String to XOR with decided key
     * @return XORd output
     */
    public String xorMessage(String message) {
        // Checks message is in correct format
        isCorrectFormat(message);

        // Adjusts the length of our key to meet needs
        String key = keyToLength(message.length());

        // Loops through message, XORing and appending to output string
        String output = "";
        for (int i = 0; i < message.length(); i++) {
            char charAtI = message.charAt(i);
            if ((charAtI == '1' && key.charAt(i) == '1') || (charAtI == '0' && key.charAt(i) == '0')) {
                output += "0";
            } else if (charAtI == ' ') {
                output += " ";
            } else {
                output += "1";
            }
        }
        return output;
    }
    
    // Decode and Encoded methods that do the same thing, different names for easier reading/understanding

    public String decode(String message) {
        return xorMessage(message);
    }
    
    public String encode(String message) {
        return xorMessage(message);
    }

}
