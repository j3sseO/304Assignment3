// Name: Jesse OConnor
// ID: 1534760

import java.util.Random;
import java.util.ArrayList;

/**
 * Emulation class
 * Emulation of the QKE algorithm, followed by secure echange of a symmetrically
 * encrypted message using the key produced by QKE.
 * Experiments using 16, 256, and 1024 qubit stream lengths
 */
public class Emulation {
    
    // Arrays to hold values from receiver
    static ArrayList<String> receiverRandomPolarization = new ArrayList<>();
    static ArrayList<String> receiverMeasuredValues = new ArrayList<>();

    // Initialises string as empty
    static String key = "";

    static Random rand = new Random();

    /**
     * Main entry method of class
     */
    public static void main(String[] args) {
        // Takes value inputted by user
        if (!(args.length >= 1)) {
            System.err.print("Usage: java Emulation <bits to encrypt and transmit>");
            return;
        }

        // Gets bits inputted by user, adds them to array then to string
        // Done in case there are spaces
        String[] bits = new String[args.length];
        for (int i = 0; i < bits.length; i++) {
            bits[i] = args[i];
        }
        String bitsToSend = "";
        for (String bit : bits) {
            bitsToSend += bit;
        }

        // Starts initial transmit of 16 qubits
        initialTransmit(1024);
        System.out.println("\nKey decided by Quantum Key Encryption:\n" + key);
        XOR xor = new XOR(key);
        
        // Encodes string with decided key
        String encodedString = xor.encode(bitsToSend);
        System.out.println("\nEncoded string:\n" + encodedString);

        // Decodes string with decided key
        System.out.println("\nDecoded string:\n" + xor.decode(encodedString) + "\n");
    }

    /**
     * initialTransmit of qubits to receiver
     * @param streamLength Specified length of qubit stream
     */
    public static void initialTransmit(int streamLength) {
        // ArrayLists to store polarization and values of qubits
        ArrayList<String> qubitsPolarization = new ArrayList<>();
        ArrayList<String> qubitsValue = new ArrayList<>();
        ArrayList<Qubit> qubits = new ArrayList<>();

        // Creates parametered amount of qubits and stores them in array
        for (int i = 0; i < streamLength; i++) {
            Qubit qubit = new Qubit(rand.nextInt(2), rand.nextInt(2));
            qubits.add(qubit);
            qubitsValue.add(Integer.toString(qubit.getValue()));
            qubitsPolarization.add(Integer.toString(qubit.getPolarization()));
        }

        // Calls emulation of transmitting stream of qubits to receiver
        initialReceive(qubits);
        // Transmits polarization of qubits
        transmitPolarization(qubitsPolarization);
    }

    /**
     * initialReceive method that emulates a receivers inital actions in QKE
     * @param qubits Stream of qubits that are received
     */
    public static void initialReceive(ArrayList<Qubit> qubits) {
    
        // Stores polarization and values from stream of qubits
        for (Qubit qubit : qubits) {
            receiverRandomPolarization.add(Integer.toString(rand.nextInt(2)));
            // Calls measure method on values
            receiverMeasuredValues.add(Integer.toString(qubit.measure(0)));
        }
    }

    /**
     * transmitPolarization method, key is formed by recorded qubits values
     * where both happen to use the same polarization type/value.
     * @param polarization
     */
    public static void transmitPolarization(ArrayList<String> polarization) {
        // Loops through the array of polarization types, if they match,
        // get value from that index and append it to key
        for (int i = 0; i < polarization.size(); i++) {
            if (polarization.get(i).compareTo(receiverRandomPolarization.get(i)) == 0) {
                key += receiverMeasuredValues.get(i);
            }
        }
    }
}