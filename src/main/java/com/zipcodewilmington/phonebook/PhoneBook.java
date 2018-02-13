package com.zipcodewilmington.phonebook;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private String name;
    private String number;

    TreeMap<String, String> nameNumberBook = new TreeMap<String, String>();

    public PhoneBook(){

    }

    public PhoneBook(String name, String number){
        this.name = name;
        this.number = number;

    }

    public void add(String name, String number){

        nameNumberBook.put(name, number);
    }

    public void remove(String name){

        nameNumberBook.remove(name);
    }

    public String lookup(String name){

        return nameNumberBook.get(name);
    }

    public String reverseLookup(String number){

        for (Map.Entry<String, String> values : nameNumberBook.entrySet()) {
            if(values.getValue() == number) {
                String getString = values.getKey();
                return getString;
            }
        }
        return "Can not find match to phone number!";
    }

    public String listNames(){

        Set<String> contacts = nameNumberBook.keySet();

        //String contacts2 = nameNumberBook.keySet();

        String allContacts = "";
        for(String name : contacts){
            //System.out.println(name + "\n");
            allContacts += name + "\n";
        }
        return allContacts;
    }

    public String listPhoneBook() {

        String contactsAndNumbers = "";

        for (Map.Entry<String, String> values : nameNumberBook.entrySet()) {
            String getKeys = String.format("%1$-10s", values.getKey());
            String getValues = String.format("%1$-10s", values.getValue());

            //String getKeys = entry.getKey() + ":  ";
            //tring getValues = entry.getValue();

            contactsAndNumbers += getKeys + getValues + "\n";
        }

        return contactsAndNumbers;
    }

    public static void main(String[] args) {

        PhoneBook phonebook = new PhoneBook();

        phonebook.add("George", "123.456.7890");
        //phonebook.remove("George");
        phonebook.add("Pete", "292.349.8023");
        phonebook.add("Dan", "854.930.2175");
        phonebook.add("Brad", "609.489.2345");
        phonebook.add("Stan", "346.256.1765");
        phonebook.add("Luke", "367.945.3984");

        //phonebook.lookup("George");
        //phonebook.remove("George");

        //System.out.println(phonebook.lookup("George"));
        System.out.println(phonebook.listNames());
        System.out.println(phonebook.listPhoneBook());
        System.out.println(phonebook.reverseLookup("123.456.7890"));
        System.out.println(phonebook.reverseLookup("123.456.7891"));



    }
}
