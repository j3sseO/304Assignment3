// Name: Jesse OConnor
// ID: 1534760

import java.util.Random;

/**
 * Quibit class
 * Sent as photons and can be encoded via a photon's polarizaztion
 */
public class Qubit {

    private int value;
    // 0 for circular, 1 for linear
    private int polarization;

    /**
     * Quibit constructor
     * @param value Quibit value
     * @param polarization Quibit polarization
     */
    public Qubit(int value, int polarization) {
        this.value = value;
        this.polarization = polarization;
    }

    /**
     * Sets new value and polarization of Quibit
     * @param value New value
     * @param polarization New polarization
     */
    public void set(int value, int polarization) {
        this.value = value;
        this.polarization = polarization;
    }

    /*
     * Measure method that returns instantly if polarization matches otherwise,
     * sets value to 0 or 1 with 50/50 chance
     */
    public int measure(int polarization) {
        Random rand = new Random(); 
        if (polarization != this.polarization) {
            int value = rand.nextInt(2);
            this.set(value, polarization);
        }

        return this.value;
    }

    public int getValue() { return value; }
    public int getPolarization() { return polarization; }

}