package com.zipcodewilmington.phonebook;

/**
 * Created by leon on 1/23/18 updated by Joshua Wurdemann 2/12/2018.
 */

import java.util.*;

/**
 * Phone Book
 * add
 * remove
 * lookup
 * listNames
 * ListAll
 * ReverseLookup
 */
public class PhoneBook {

    private TreeMap<String, Person> phoneBook;

    public PhoneBook(TreeMap thisEntry) {
        phoneBook = thisEntry;

    }

    /**
     * might change method Param to an Object.
     *
     * @return
     */
    public boolean add(String name, String phoneNumber) {
        boolean personAdded = false;
        if (!phoneBook.containsKey(name)) {
            // if a person has more than one phonenumber add phone number list of phoneNumbers
            ArrayList<String> listOfNumbers = new ArrayList<>();
            listOfNumbers.add(phoneNumber);
            Person somePerson = new Person(name, phoneNumber, listOfNumbers);
            phoneBook.put(name, somePerson);
            return personAdded = true;
        }

        personAdded = addNumberToList(phoneNumber);

        return personAdded;
    }

    public boolean addNumberToList(String phoneNumber) {
        boolean addedNumber = false;
        /** I want to add phone number to List of Phone numbers
         *  check to see if add and return result accordingly;
         */
        //int index = lookUpPhoneNumber(phoneNumber).getListOfNumbers().indexOf(phoneNumber);
        //if (index < 0) {
            lookUpPhoneNumber(phoneNumber).getListOfNumbers().add(phoneNumber);
            addedNumber = lookUpPhoneNumber(phoneNumber).getListOfNumbers().contains(phoneNumber);

       // }
        return addedNumber;
    }
    //public boolean removeNumberFromListing()

    /**
     * @param name
     * @return
     */
    public boolean removeListing(String name) {
        boolean removedName = false;

        if (phoneBook.containsKey(name)) {
            phoneBook.remove(name);
            removedName = true;
        }
        return removedName;
    }

    /**
     * remove a phone number from a list of numbers.
     */
    public boolean removeAPhoneNumber(String name, String phoneNumber) {
        boolean removedANumber = false;
        try {
            if (phoneBook.containsKey(name)) {
                lookUpPhoneNumber(phoneNumber).getListOfNumbers().remove(phoneNumber);
                //removedANumber = true;
            }
        } catch (NullPointerException e) {
            System.out.println("No phoneNumber exsists");
        }
        return removedANumber;
    }

    /**
     * @param phoneNumber
     * @return
     */
    public Person lookUpPhoneNumber(String phoneNumber) {
        /**reverse lookup need to look value "phoneNumber"*/
        for (Map.Entry<String, Person> entry : phoneBook.entrySet()) {

            int index = entry.getValue().getListOfNumbers().indexOf(phoneNumber);

            if (entry.getValue().getListOfNumbers().get(index).equals(phoneNumber)) {
                return entry.getValue();
            }
        }
        return null; // change this
    }

    /**
     * @param name
     * @return
     */
    public Person lookUpName(String name) {

        return phoneBook.get(name);
    }

    /**
     * @return
     */
    public String[] getlistAllNames() {

        Set<String> keys = phoneBook.keySet();

        System.out.println(keys.toString());
        return keys.toArray(new String[keys.size()]);

    }

    /**
     * @return
     */
    public Object[] getlistAllListings() {
        // returns all the values into a collection of objects.
        Collection value = phoneBook.values();
        String s = value.toString();
        System.out.println(s);

        return value.toArray(new Object[value.size()]);
        // String listAll = value.toString();


    }
}
