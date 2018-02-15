package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new TreeMap<String, List<String>>();
    }

    public boolean add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phone);
            return true;

        } else {
            List<String> contactNumbers = new ArrayList<String>();
            contactNumbers.add(phone);
            phoneBook.put(name, contactNumbers);
        }

        return true;
    }

    public boolean remove(String name) {
        return phoneBook.remove(name) != null;
    }

    public String lookup(String name) {
        String myNumbers = "";
        for (String key : phoneBook.keySet()) {
            for (int i = 0; i < phoneBook.get(key).size(); i++) {
                myNumbers += phoneBook.get(key).get(i) + "  ";
            }

        }
        return myNumbers;
    }

    public String listNames() {
        String names = "";
        for (String a : phoneBook.keySet()) {
            names += a + "\n";
        }

        return names;
    }

    public String listNamesAndNumbers() {
        StringBuilder namesAndNumbers = new StringBuilder();
        for (String keys : phoneBook.keySet()) {
            List<String> contact = phoneBook.get(keys);
            for (String num : contact) {
                namesAndNumbers.append(keys).append("    ").append(num);
            }
            namesAndNumbers.append("\n");
        }
        return namesAndNumbers.toString();
    }

    public String reverseLookUp(String number) {
        for (String keys : phoneBook.keySet()) {
            for (int i = 0; i < phoneBook.get(keys).size(); i++) {
                if (phoneBook.get(keys).get(i).equals(number))
                    return keys;
            }
        }
        return null;
    }


}
