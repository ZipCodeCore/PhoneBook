package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, Person> phoneBook = new TreeMap<String, Person>();


    public void addEntryToPhoneBook(String name, String phoneNumber) {
        phoneBook.put(name, new Person(name, phoneNumber));
    }


    public void removePhoneBookEntryFromPhoneBook(String name) {
        phoneBook.remove(name);
    }

    public String[] listNames() {
        return null;
    }

    public String entryListAll() {
        String fullList = "";
        Set<String> keys = phoneBook.keySet();
        for (Map.Entry<String, Person> entry: phoneBook.entrySet()) {
            fullList += entry.getKey() + " : " + entry.getValue().getPhoneNumber();

        }
        return fullList;
    }
    public static void main(String[] args) {
        PhoneBook nameNumber = new PhoneBook();
        nameNumber.addEntryToPhoneBook("eric", "3025551111 \n");
        nameNumber.addEntryToPhoneBook("eyan", "3025552222 \n");
        nameNumber.entryListAll();
        System.out.println(nameNumber.entryListAll());

    }


    public Person lookUp(String name) {
        return phoneBook.get(name);

    }


}

