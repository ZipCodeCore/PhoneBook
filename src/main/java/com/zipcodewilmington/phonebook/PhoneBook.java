package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String number;
    public TreeMap<String, ArrayList<String>>phoneBookEntries = new TreeMap<String, ArrayList<String>>();


    public PhoneBook() {

    }

    public void add(String name, String ... number) {
        ArrayList<String> listOfNumbers= new ArrayList<String>(Arrays.asList(number));
        phoneBookEntries.put(name, listOfNumbers);
    }

    public void addExtraNumber(String name, String number) {
        phoneBookEntries.get(name).add(number);
    }


    public void removeNumber(String name, String number){
        phoneBookEntries.get(name).remove(number);
    }

    public void removeRecord(String name) {
        phoneBookEntries.remove(name);
    }

    public String lookUp(String name) {
        ArrayList<String> matchingNumbers= phoneBookEntries.get(name);
        String returnNumbers="";
        for (String number : matchingNumbers)
        {
            returnNumbers += number + "\n";
        }

        return returnNumbers.trim();

    }

    public String listNames() {

        Set<String> contacts = phoneBookEntries.keySet();
        String allContacts = "";

        for (String name : contacts) {
            allContacts += name + "\n";
        }

        return allContacts.trim();

    }

    public String listNamesAndNumbers() {

        Set<String> contacts = phoneBookEntries.keySet();
        String allContacts = "";

        for (String name : contacts) {
            allContacts += name+ ":\n";
            for(int i=0; i<phoneBookEntries.get(name).size();i++){
                allContacts+=phoneBookEntries.get(name).get(i)+ "\n";
            }
        }

        return allContacts.trim();
    }

        public  String reverseLookUp(String value) {

            Set<String> contacts = phoneBookEntries.keySet();
            for(String name: contacts){
                for(int i=0;i<phoneBookEntries.get(name).size();i++) {
                    if (phoneBookEntries.get(name).get(i).equals(value)) {
                        return name;
                    }
                }

            }
            return null;

    }
}