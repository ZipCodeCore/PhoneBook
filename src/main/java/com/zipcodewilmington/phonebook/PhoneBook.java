package com.zipcodewilmington.phonebook;

import java.util.Formatter;
import java.util.Map;
import java.util.TreeMap;
import java.util.Arrays;

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
    public Boolean addNameAndNumber(String name, String number) {
        return phoneRecord.put(name, number) != null;
    }

    /**
     * uses name to retrieve and delete both name and phone number
     *
     * @param name
     */
    public boolean deleteNameAndNumber(String name) {
        return phoneRecord.remove(name) != null;
    }


    /**
     * retrieves phone number by name
     *
     * @param name
     */
    public String retrieveByName(String name) {
        return phoneRecord.get(name);
    }

    /**
     * retrieves name by phone number
     *
     * @param number
     */
    public String retrieveByPhoneNumber(String number) {
        for (String nameKey : phoneRecord.keySet()) {
            String numValue = phoneRecord.get(nameKey);
            if (numValue.equals(number)) {
                return phoneRecord.get(nameKey);
            }
        }
        return "";
    }

    /**
     * returns alphabetical list of all names in phoneBook
     */
    public String listAllNames() {
        StringBuilder list = new StringBuilder();
        Formatter prettyListNames = new Formatter(list);
        for (String nameKey : phoneRecord.keySet()) {
            prettyListNames.format("Name: %s%n",nameKey);
        }
        return list.toString();
    }

    /**
     * returns alphabetical list of all records in phoneBook
     */
    public String listAllNamesAndNumbers() {
        StringBuilder list = new StringBuilder();
        Formatter prettyList = new Formatter(list);
        for (String nameKey : phoneRecord.keySet()) {
            prettyList.format("Name: %-7s PhoneNumber: %-10s%n", nameKey, phoneRecord.get(nameKey));
        }
        return list.toString();
    }

    public static void main(String[] args) {

        PhoneBook lancasterPeople = new PhoneBook();
        lancasterPeople.addNameAndNumber("Sally", "7173419899");
        lancasterPeople.addNameAndNumber("Zach", "7173413244");
        lancasterPeople.addNameAndNumber("Adam", "7173419675");
        lancasterPeople.addNameAndNumber("Chance", "555");
        lancasterPeople.addNameAndNumber("Wally", "8906786");


        String x = lancasterPeople.listAllNamesAndNumbers();
        System.out.println(x);

        String y = lancasterPeople.listAllNames();
        System.out.println(y);


    }

}






