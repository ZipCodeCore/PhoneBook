package com.zipcodewilmington.phonebook;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    TreeMap<String, Person> nameNumberBook = new TreeMap<String, Person>();

    public PhoneBook(){

    }

    public void add(String name, String number){
        Person person = new Person(name, number);
        nameNumberBook.put(name, person);
    }

    public void removeRecord(String name){

        nameNumberBook.remove(name);

    }

    public String lookup(String name){

        return nameNumberBook.get(name).getPhoneNumbers();
    }

    public String reverseLookup(String number){

        for(Map.Entry<String, Person> entry : nameNumberBook.entrySet()){
            if (entry.getValue().getPhoneNumbers().contains("[" + number + "]")){
                String keyAtValue = entry.getKey();
                return keyAtValue;
            }
        }
        return "Could not find person!";
    }

    public String listNames(){

        Set<String> contacts = nameNumberBook.keySet();

        String allContacts = "";
        for(String name : contacts){
            allContacts += name + "\n";
        }
        return allContacts;
    }

    public String listPhoneBook() {

        String phoneList = "";

        Set<String> keys = nameNumberBook.keySet();
        for(String values : keys){
            phoneList += values + ": " + nameNumberBook.get(values).getPhoneNumbers() + "\n";
        }
        return phoneList;
    }

    public static void main(String[] args) {

    }
}
