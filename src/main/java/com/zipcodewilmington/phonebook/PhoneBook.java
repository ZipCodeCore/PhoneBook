package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private Map<String, String> phoneRecord;

    public PhoneBook() {
        phoneRecord = new TreeMap<String, String>();
    }

    /**
     * adds a name and corresponding phone number to phone book
     *
     * @param name
     * @param number
     */
    public void addNameAndNumber(String name, String number) {
        if (!phoneRecord.containsKey(name)) {
            phoneRecord.put(name, number);
            System.out.println("Record was successfully added to the Phone Book.");
        } else {
            System.out.println("Phone Book already contains " + name);
        }
    }

    /**
     * uses name to retrieve and delete both name and phone number
     *
     * @param name
     */
    public void deleteNameAndNumber(String name) {
        if (phoneRecord.containsKey(name)) {
            phoneRecord.remove(name);
            System.out.println("Record was successfully deleted from the Phone Book.");
        } else {
            System.out.println("Phone Book does not contain " + name);
        }
    }

    /**
     * retrieves phone number by name
     *
     * @param name
     */
    public void retrieveByName(String name) {
        if (phoneRecord.containsKey(name)) {
            String phoneNum = phoneRecord.get(name);
            System.out.println("The phone number for " + name + " is " + phoneNum);
        } else {
            System.out.println("Phone Book does not contain " + name);
        }
    }

    /**
     * retrieves name by phone number
     *
     * @param number
     */
    public void retrieveByPhoneNumber(String number) {
        for (String nameKey : phoneRecord.keySet()) {
            if (number.equals(phoneRecord.get(nameKey))) {
                System.out.println("The phone number for " + nameKey + number);
            }
        }
    }

    /**
     * returns alphabetical list of all names in phoneBook
     */
    public void listAllNames() {
        for (String nameKey : phoneRecord.keySet()) {
            System.out.println(nameKey);
        }
    }

    /**
     * returns alphabetical list of all records in phoneBook
     */
    public void listAllNamesAndNumbers() {

        // Print the content of the hashMap
        for (String nameKey : phoneRecord.keySet()) {
            System.out.println("Name: " + nameKey + ", PhoneNumber: " + phoneRecord.get(nameKey));
        }
    }

    public static void main(String[] args) {

        PhoneBook lancasterPeople = new PhoneBook();

        lancasterPeople.addNameAndNumber("Sally", "7173419899");
        lancasterPeople.addNameAndNumber("Zach", "7173413244");
        lancasterPeople.addNameAndNumber("Adam", "7173419675");
        lancasterPeople.addNameAndNumber("Chance", "555");
        lancasterPeople.addNameAndNumber("Wally", "8906786");

        lancasterPeople.listAllNames();
        lancasterPeople.listAllNamesAndNumbers();

        lancasterPeople.retrieveByPhoneNumber("7173416306");
        lancasterPeople.retrieveByName("Sally");
        lancasterPeople.deleteNameAndNumber("Zach");
        lancasterPeople.retrieveByName("Zach");
        lancasterPeople.retrieveByName("jkl");
        lancasterPeople.listAllNames();


    }

}






