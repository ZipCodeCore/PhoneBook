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
        //Person somePerson = new Person(name, phoneNumber);
        boolean personAdded = false;

        if (!phoneBook.containsKey(name)) {
            Person somePerson = new Person(name, phoneNumber);
            phoneBook.put(name, somePerson);
            personAdded = true;
        }




        return personAdded;
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
     * @param phoneNumber
     * @return
     */
    public Person lookUpPhoneNumber(String phoneNumber) {
        /**reverse lookup need to look value "phoneNumber"*/
        for (Map.Entry<String, Person> entry : phoneBook.entrySet()) {
            if (entry.getValue().getNumber().equals(phoneNumber)) {
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
