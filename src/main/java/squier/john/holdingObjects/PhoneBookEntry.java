package squier.john.holdingObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * @author John A. Squier
 */
public class PhoneBookEntry implements Comparable<PhoneBookEntry> {

    private String name;
    private List<PhoneNumber> numbers;

    public PhoneBookEntry(String name, PhoneNumber number) {
        this.name = name;
        this.numbers = new ArrayList<>();
        numbers.add(number);
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return numbers;
    }

    public String getName() {
        return name;
    }

    public boolean equals(PhoneBookEntry other) {
        if ( this.name.equals(other.name )
                && this.numbers.equals(other.numbers) ) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        String phoneNumbers = "";

        for ( PhoneNumber n : numbers ) {
            phoneNumbers += n.toString() + "\n";
        }

        String s = name + ": " + phoneNumbers;
        return s;
    }

    public int compareTo(PhoneBookEntry other) {
        return this.name.compareTo(other.name);
    }
}
