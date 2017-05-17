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

    Map<String,ArrayList<String>> map;

    PhoneBook() {
        map = new TreeMap<String,ArrayList<String>>();
    }

    private String validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {   // Valid phone number
            return phoneNumber;
        }
        try {
            Long.parseLong(phoneNumber);
        } catch (Exception e) {
            throw new InvalidPhoneNumberFormatException();
        }
        return buildPhoneNumber(phoneNumber);
    }

    private String buildPhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if(phoneNumber.length() != 10 || phoneNumber.charAt(0) == 0){
            throw new InvalidPhoneNumberFormatException();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(phoneNumber.charAt(0));
        sb.append(phoneNumber.charAt(1));
        sb.append(phoneNumber.charAt(2));
        sb.append(") ");
        sb.append(phoneNumber.charAt(3));
        sb.append(phoneNumber.charAt(4));
        sb.append(phoneNumber.charAt(5));
        sb.append("-");
        sb.append(phoneNumber.charAt(6));
        sb.append(phoneNumber.charAt(7));
        sb.append(phoneNumber.charAt(8));
        sb.append(phoneNumber.charAt(9));

        return sb.toString();
    }

    ArrayList<String> lookUp(String name) {
        return map.get(name);
    }

    /*
    Helper method for addRecord.
     */
    private ArrayList<String> createNewRecord(String name, String phoneNumber) {
        ArrayList<String> list = new ArrayList<String>();
        list.add(phoneNumber);
        return map.put(name, list);
    }

    /*
    Not sure if it'd be better to switch the blocks in if and else.
     */
    ArrayList<String> addRecord(String name, String phoneNumber) {
        if(map.get(name) == null) {
            return createNewRecord(name, phoneNumber);
        } else {
            map.get(name).add(phoneNumber);
            return map.get(name);
        }
    }

    ArrayList<String> addRecords(String name, String... phoneNumbers) {
        for(String s : phoneNumbers) {
            addRecord(name, s);
        }
        return map.get(name);
    }

    ArrayList<String> removeRecordByName(String name) {
        return map.remove(name);
    }

    boolean removePhoneNumber(String phoneNumber) {
        String name = reverseLookUp(phoneNumber);
        return name != null && map.get(name).remove(phoneNumber);
    }

    String allNamesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    String allEntriesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    String reverseLookUp(String number) {
        for(String s : map.keySet()) {
            if(map.get(s).contains(number)) {
                return s;
            }
        }
        return null;
    }

}
