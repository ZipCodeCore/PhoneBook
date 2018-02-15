package com.zipcodewilmington.phonebook;
import java.util.*;
import java.util.TreeMap;
import java.util.Set;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    String name;
    String number;
    ArrayList<String> numbersList = new ArrayList<>();


    private TreeMap contactsList;

    public PhoneBook() {
        this.contactsList = new TreeMap<>();

    }

    public Map<String, ArrayList> getContactsList() {
        return contactsList;

    }

    public String addContact(String name, String number) {
        if (!contactsList.containsKey(name)) {
            contactsList.put(name, number);
        }
        return "";
    }

    public String removeContact(String name) {
        if (contactsList.containsKey(name)) {
            contactsList.remove(name);
        }
        return "";
    }


    public String listAllNamesAndNumbers() {
        Set listingAll = contactsList.entrySet();
        return listingAll.toString();
        /*String getEntries = new String();
        for (Object allEntries : listingAll) {
            if(listingAll.equals());*/
        }



    public String reverseLookUp() {
        Set<String> listingReverse = contactsList.keySet();
        for (String allEntries : listingReverse) {
            if(listingReverse.contains(allEntries.equals(number))) {
                return allEntries;
            }

        }
        return "";
    }
}







