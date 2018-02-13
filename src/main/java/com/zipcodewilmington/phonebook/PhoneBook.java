package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, String> phoneBook;

    public PhoneBook(){
        this.phoneBook = new TreeMap<String, String>();
    }



    public void add(String name, String phoneNumber){
        phoneBook.put(name, phoneNumber);
        //System.out.println(phoneBook);
    }

    public String lookUp(String name){
        String result = phoneBook.get(name);
        return result;
    }

    public String getPhoneBook() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry : phoneBook.entrySet()){
            result.append(String.format("%-20s %8s\n", entry.getKey(), entry.getValue()));
        }
        return String.valueOf(result);
    }

    public void removeEntry(String name){
        phoneBook.remove(name);
        //System.out.println(getPhoneBook());
    }
}