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

Add a reverseLookup() method to PhoneBook. This method should allow you to look up names by the phone number associated with them.


 */

import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    TreeMap<String,Long> map;

    PhoneBook() {
        map = new TreeMap<String,Long>();
    }

    Long lookUp(String name) {
        return map.get(name);
    }

    Long add(String name, long phoneNumber) {
        return map.put(name, phoneNumber);
    }

    Long remove(String name) {
        return map.remove(name);
    }

    String getAllPersons() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,Long> entry : map.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    String getAllEntries() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,Long> entry : map.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    String reverseLookUp(Long number) {
        for(String s : map.keySet()) {
            if(map.get(s).equals(number)) {
                return s;
            }
        }
        return null;
    }

}
