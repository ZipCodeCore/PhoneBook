package com.zipcodewilmington.phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, String> phoneRecord;

    public PhoneBook() {
        //create hashmap <declare data types here>
        phoneRecord = new TreeMap<String, String>();
    }

    /**
     * adds a record to phone book
     * @param name
     * @param number
     */
    public void add(String name, String number) {
        if (!phoneRecord.containsKey(name)) {
            phoneRecord.put(name, number);
            System.out.println("Record was successfully added to the Phone Book.");
        } else {
            System.out.println("Phone Book already contains " + name);
        }
    }

    /**
     * removes record
     * @param name
     */
    public void remove(String name) {
        if (phoneRecord.containsKey(name)) {
            phoneRecord.remove(name);
            System.out.println("Record was successfully deleted from the Phone Book.");
        } else {
            System.out.println("Phone Book does not contain " + name);
        }
    }

    /**
     * retrieves record by name
     * @param name
     */
    public void lookup(String name) {
        if (phoneRecord.containsKey(name)) {
            String phoneNum = phoneRecord.get(name);
            System.out.println("The phone number for " + name + " is " + phoneNum);
        } else {
            System.out.println("Phone Book does not contain " + name);
        }
    }

    /**
     * retrieves record by number
     * @param number
     */
    public void reverseLookUp(String number) {
        for (String nameKey : phoneRecord.keySet()) {
            if (number.equals(phoneRecord.get(nameKey))) {
                System.out.println("The phone number for " + nameKey + number);
            }
        }
    }

    /**
     * returns list of all names in phoneBook
     */
    public void listAllNames() {
        for (String nameKey : phoneRecord.keySet()) {
            System.out.println(nameKey);
        }
    }

    /**
     * returns list of all records in phoneBook
     */
    public void listAllNamesAndNumbers() {

        // Print the content of the hashMap
        for (String nameKey : phoneRecord.keySet()) {
            System.out.println("Name: " + nameKey + ", PhoneNumber: " + phoneRecord.get(nameKey));
        }
    }

    public static void main(String[] args) {

        PhoneBook lancasterPeople = new PhoneBook();

        lancasterPeople.add("Sally", "7173419899");
        lancasterPeople.add("Zach", "7173413244");
        lancasterPeople.add("Adam", "7173419675");
        lancasterPeople.add("Chance", "555");
        lancasterPeople.add("Wally", "8906786");

        lancasterPeople.listAllNames();
        lancasterPeople.listAllNamesAndNumbers();

        lancasterPeople.reverseLookUp("7173416306");
        lancasterPeople.lookup("Sally");
        lancasterPeople.remove("Zach");
        lancasterPeople.lookup("Zach");
        lancasterPeople.lookup("jkl");
        lancasterPeople.listAllNames();



    }

}
