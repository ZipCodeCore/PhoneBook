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

    public void remove(String name){
        nameNumberBook.remove(name);
    }

    public String lookup(String name){

        return nameNumberBook.get(name).getPhoneNumbers();
    }

    public String reverseLookup(String number){

        //Set<Map.Entry<String, Person>> entries = nameNumberBook.entrySet();

        for(Map.Entry<String, Person> entry : nameNumberBook.entrySet()){
            if (entry.getValue().getPhoneNumbers().equals("[" + number + "]")){
                String keyAtValue = entry.getKey();
                return keyAtValue;
        }

        } return "Not found";
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

        String phoneList = "";

        Set<String> keys = nameNumberBook.keySet();
        for(String values : keys){
            phoneList += values + ": " + nameNumberBook.get(values).getPhoneNumbers() + "\n";
        }
        return phoneList;
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
        //System.out.println(phonebook.reverseLookup("123.456.7891"));



    }
}
