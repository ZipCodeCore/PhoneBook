package squier.john.holdingObjects;

/**
 * @author John A. Squier
 * Stores a phone number input in the form "123-456-7890".
 */
public class PhoneNumber {

    private int areaCode;
    private int firstThreeDigits;
    private int lastFourDigits;

    public PhoneNumber(String numberAsString) {
        String[] split = numberAsString.split("-");

        if ( split.length == 3 ) {
            areaCode = Integer.parseInt(split[0]);
            firstThreeDigits = Integer.parseInt(split[1]);
            lastFourDigits = Integer.parseInt(split[2]);
        }
    }

    public String toString() {
        String s = Integer.toString(areaCode) + "-"
                    + Integer.toString(firstThreeDigits) + "-"
                    + Integer.toString(lastFourDigits);
        return s;
    }

    public boolean equals(PhoneNumber other) {
        if ( this.areaCode == other.areaCode
                && this.firstThreeDigits == other.firstThreeDigits
                && this.lastFourDigits == other.lastFourDigits ) {
            return true;
        }
        else {
            return false;
        }
    }
}
