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
            personAdded = listOfNumbers.add(phoneNumber);
            Person somePerson = new Person(name, phoneNumber, listOfNumbers);
            phoneBook.put(name, somePerson);
            return personAdded;
        }

        personAdded = addNumberToList(name ,phoneNumber);

        return personAdded;
    }

    public boolean addNumberToList(String name, String phoneNumber) {
        boolean addedNumber = false;
        /** check for existing phonenumber.
          there is no phone exisiting number add to list*/
         if(lookUpPhoneNumber(phoneNumber) == null){
            addedNumber = lookUpName(name).getListOfNumbers().add(phoneNumber);
        }
        return addedNumber;
    }


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
              removedANumber =  lookUpPhoneNumber(phoneNumber).getListOfNumbers().remove(phoneNumber);
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
        boolean isPhoneNumber = false;
        /**reverse lookup need to look value "phoneNumber"*/
        for (Map.Entry<String, Person> entry : phoneBook.entrySet()) {

            isPhoneNumber = entry.getValue().getListOfNumbers().contains(phoneNumber);

            if (isPhoneNumber == true) {
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
