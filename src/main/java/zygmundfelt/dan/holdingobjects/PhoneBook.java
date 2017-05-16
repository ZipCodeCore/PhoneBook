package zygmundfelt.dan.holdingobjects;

/*
Create a PhoneBook class that holds names and phone numbers
in sorted order. You can use an associative data type (one
which stores items as keys paired with values).

Your PhoneBook class should have a lookup() method which
allows you to look up a person's phone number based on their
name. PhoneBook should also have methods to add and remove
entries, or to list all names or all entries (names an phone
numbers).
 */

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    TreeMap<Person, PhoneNumber> map;

    PhoneBook() {
        map = new TreeMap<Person, PhoneNumber>();
    }

    PhoneNumber lookUp(Person person) {
        return null;
    }

    void put(Person person, PhoneNumber number) {
        return;
    }

    int size() {
        return 0;
    }

    Person[] getAllPersons() {
        return null;
    }

    Entry<Person, PhoneNumber> getAllEntries() {
        return null;
    }

}
