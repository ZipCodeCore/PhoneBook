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
                return this.get(i).getPhoneNumbers().get(0);
            }
        }
        return null;
    }

    public String reverseLookup(PhoneNumber toLookUp) {
        for ( int i = 0; i < this.size(); i++ ) {

            for ( int j = 0; j < this.get(i).getPhoneNumbers().size(); j++ ) {

                if ( this.get(i).getPhoneNumbers().get(j).equals(toLookUp) ) {
                    return this.get(i).getName();
                }
            }
        }

        return null;
    }

    public boolean addEntry(PhoneBookEntry toAdd) {
        boolean added = false;

        for ( int i = 0; i < this.size(); i++ ) {
            if (this.get(i).getName().equals(toAdd.getName())) {
                this.get(i).addNumberToEntry(toAdd.getPhoneNumbers().get(0));
                added = true;
            }
        }

        // name isnt in phonebook
        if ( added == false ) {
            added = this.add(toAdd);
        }

        Collections.sort(this);
        return added;
    }

    public boolean removeEntry(PhoneBookEntry toRemove) {
        // check if the entry has multiple numbers and if so delete the one given
        //      otherwise delete the whole entry
        for ( PhoneBookEntry p : this ) {

            if (p.getName().equals(toRemove.getName())) {

                if (p.getPhoneNumbers().size() > 1) {

                    for (PhoneNumber n : p.getPhoneNumbers()) {

                        if (n.equals(toRemove.getPhoneNumbers().get(0))) {
                            p.getPhoneNumbers().remove(n);
                            Collections.sort(this);
                            return true;
                        }
                    }
                }
                else {
                    this.remove(p);
                    Collections.sort(this);
                    return true;
                }
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
