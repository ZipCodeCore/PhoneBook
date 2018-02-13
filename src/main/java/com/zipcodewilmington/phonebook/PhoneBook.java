package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList> phoneBookList = new TreeMap<String, ArrayList>();

    public void addEntryToPhoneBook(String name, String... phonenumbers) {
        ArrayList phonenumberList = new ArrayList();
        for (String number: phonenumbers
             ) {phonenumberList.add(number);

        }
        phoneBookList.put(name, phonenumberList);
    }

    public void removeEntryFromPhoneBook(String name) {
        phoneBookList.remove(name);
    }

    public String listAllNames() {
        return phoneBookList.keySet().toString();
    }

    public String listAllEntries() {
        return phoneBookList.entrySet().toString();
    }

    public String lookupPhonenumber(String name) {
        return phoneBookList.get(name).toString();
    }

    public String lookupNameByPhonenumber(String phonenumber) {
        for (Map.Entry<String, ArrayList> entry : phoneBookList.entrySet()) {
            if (entry.getValue().toString().equals(phonenumber)) {
                return entry.getKey();

            }

        }
        return "Number not found";
    }

    public String removeSinglePhonenumber( String name, String phonenumber) {

    }
}
