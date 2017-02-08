package squier.john.holdingObjects;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author John A. Squier
 */
public class PhoneBook extends ArrayList<PhoneBookEntry> {

    public PhoneBook() {
        super();
    }

    public PhoneNumber lookup(String name) {
        for ( int i = 0; i < this.size(); i++ ) {
            if ( this.get(i).getName().equals(name) ) {
                return this.get(i).getPhoneNumber();
            }
        }
        return null;
    }

    public String reverseLookup(PhoneNumber toLookUp) {
        for ( int i = 0; i < this.size(); i++ ) {
            if ( this.get(i).getPhoneNumber().equals(toLookUp) ) {
                return this.get(i).getName();
            }
        }
        return null;
    }

    public boolean addEntry(PhoneBookEntry toAdd) {
        boolean b = add(toAdd);
        Collections.sort(this);
        return b;
    }

    public boolean removeEntry(PhoneBookEntry toRemove) {
        for ( int i = 0; i < this.size(); i++ ) {
            if ( this.get(i).equals(toRemove) ) {
                remove(i);
                Collections.sort(this);
                return true;
            }
        }

        return false;
    }

    public String[] listAllNames() {
        String[] allNames = new String[this.size()];

        for ( int i = 0; i < this.size(); i++ ) {
            allNames[i] = this.get(i).getName();
        }

        return allNames;
    }

    public PhoneBookEntry[] listAllEntries() {
        PhoneBookEntry[] allEntries = new PhoneBookEntry[this.size()];

        for ( int i = 0; i < this.size(); i++ ) {
            allEntries[i] = this.get(i);
        }

        return allEntries;
    }
}
