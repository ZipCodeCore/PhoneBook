package squier.john.holdingObjects;

/**
 * @author John A. Squier
 * Stores a phone number input in the form "(123)-456-7890".
 */
public class PhoneNumber {

    private int areaCode;
    private int firstThreeDigits;
    private int lastFourDigits;

    public PhoneNumber(String numberAsString) throws InvalidPhoneNumberFormatException {
        String[] split = numberAsString.split("-");

        if ( split.length == 3 ) {
            char[] c = split[0].toCharArray();

            if ( c[0] != '(' || c[4] != ')') {
                throw new InvalidPhoneNumberFormatException();
            }

            char[] cWithoutParens = new char[3];
            cWithoutParens[0] = c[1];
            cWithoutParens[1] = c[2];
            cWithoutParens[2] = c[3];
            String cWithoutParensAsString ="" + cWithoutParens[0] + cWithoutParens[1] + cWithoutParens[2];

            areaCode = Integer.parseInt(cWithoutParensAsString);
            if ( areaCode < 0 || areaCode > 999 ) {
                throw new InvalidPhoneNumberFormatException();
            }

            firstThreeDigits = Integer.parseInt(split[1]);
            if ( firstThreeDigits < 0 || firstThreeDigits > 999 ) {
                throw new InvalidPhoneNumberFormatException();
            }

            lastFourDigits = Integer.parseInt(split[2]);
            if ( lastFourDigits < 0 || lastFourDigits > 9999 ) {
                throw new InvalidPhoneNumberFormatException();
            }
        }
        else {
            throw new InvalidPhoneNumberFormatException();
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
