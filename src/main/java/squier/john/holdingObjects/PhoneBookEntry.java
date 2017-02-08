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

    public boolean addNumberToEntry(PhoneNumber newNumber) {
        boolean added = numbers.add(newNumber);
        return added;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return numbers;
    }

    public String getName() {
        return name;
    }

    public boolean equals(PhoneBookEntry other) {
        boolean entiresEqual = true;


        if ( this.name.equals(other.name) ) {
            if ( this.getPhoneNumbers().size() == other.getPhoneNumbers().size() ) {
                for ( int i = 0; i < this.getPhoneNumbers().size(); i++ ) {
                    if ( this.getPhoneNumbers().get(i).equals(other.getPhoneNumbers().get(i)) ) {
                        // do nothing when equal
                    }
                    else {
                        entiresEqual = false;
                    }
                }
            }
            else {
                entiresEqual = false;
            }
        }
        else {
            entiresEqual = false;
        }

        return entiresEqual;
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
