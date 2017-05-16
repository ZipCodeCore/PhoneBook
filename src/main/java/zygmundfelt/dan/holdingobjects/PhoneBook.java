package zygmundfelt.dan.holdingobjects;

/*
Create a PhoneBook class that holds names and phone numbers
in sorted order. You can use an associative data type (one
which stores items as keys paired with values).

Your PhoneBook class should have a lookup() method which
allows you to look up a person's phone number based on their
name. PhoneBook should also have methods to addRecord and removeRecordByName
entries, or to list all names or all entries (names an phone
numbers).

Add a reverseLookup() method to PhoneBook. This method should
allow you to look up names by the phone number associated with
them.

Some people have more than one phone number. Refactor your
PhoneBook class to map names to lists of phone numbers. You
should modify your addRecord() and removeRecordByName() methods to handle adding
or removing individual numbers, and create a removeRecord method
for removing an entire entry from your PhoneBook.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    TreeMap<String,ArrayList<Long>> map;

    PhoneBook() {
        map = new TreeMap<String,ArrayList<Long>>();
    }

    ArrayList<Long> lookUp(String name) {
        return map.get(name);
    }

    /*
    Helper method for addRecord.
     */
    private ArrayList<Long> createNewRecord(String name, Long phoneNumber) {
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(phoneNumber);
        return map.put(name, list);
    }

    /*
    Not sure if it'd be better to switch the blocks in if and else.
     */
    ArrayList<Long> addRecord(String name, Long phoneNumber) {
        if(map.get(name) == null) {
            return createNewRecord(name, phoneNumber);
        } else {
            map.get(name).add(phoneNumber);
            return map.get(name);
        }
    }

    ArrayList<Long> addRecords(String name, Long... phoneNumbers) {
        for(Long number : phoneNumbers) {
            addRecord(name, number);
        }
        return map.get(name);
    }

    ArrayList<Long> removeRecordByName(String name) {
        return map.remove(name);
    }

    boolean removePhoneNumber(Long phoneNumber) {
        String name = reverseLookUp(phoneNumber);
        return name != null && map.get(name).remove(phoneNumber);
    }

    String allNamesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<Long>> entry : map.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    String allEntriesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<Long>> entry : map.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    String reverseLookUp(Long number) {
        for(String s : map.keySet()) {
            if(map.get(s).contains(number)) {
                return s;
            }
        }
        return null;
    }

}
