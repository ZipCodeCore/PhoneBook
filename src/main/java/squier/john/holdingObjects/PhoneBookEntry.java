package squier.john.holdingObjects;

/**
 * @author John A. Squier
 */
public class PhoneBookEntry implements Comparable<PhoneBookEntry> {

    private String name;
    private PhoneNumber number;

    public PhoneBookEntry(String name, PhoneNumber number) {
        this.name = name;
        this.number = number;
    }

    public PhoneNumber getPhoneNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean equals(PhoneBookEntry other) {
        if ( this.name.equals(other.name )
                && this.number.equals(other.number) ) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String s = name + ": " + number.toString();
        return s;
    }

    public int compareTo(PhoneBookEntry other) {
        return this.name.compareTo(other.name);
    }
}
