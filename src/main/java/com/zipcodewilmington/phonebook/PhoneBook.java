package com.zipcodewilmington.phonebook;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String number;

    TreeMap<String, String> myTree = new TreeMap<String, String>();


    public PhoneBook(){

    }

//    public PhoneBook(String name, String number) {
//        this.name = name;
//        this.number = number;
//
//    }

    public void addEntry(String name, String number) {
        myTree.put(name, number);


    }


    public void remove(String name, String number) {
        myTree.remove(name);

    }

    public String stringlookup(String name) {

       return myTree.get(name);



    }

    public String listNames() {
        ;
        Set<String> contacts = myTree.keySet();

        String allNames = "";
        for (String contact : contacts) {
            allNames += contact + "\n";

        }
        return allNames;
    }

    public String[] listPhoneBook() {

        return null;
    }


    public static void main(String[] args) {

        PhoneBook phonebookEntry = new PhoneBook();

        phonebookEntry.addEntry("Brian", "3027619121");
        phonebookEntry.addEntry("Dan", "4846394190");
        phonebookEntry.addEntry("Garret", "3027894586");

        System.out.println(phonebookEntry.listNames());

        phonebookEntry.stringlookup("Brian");

        System.out.println(phonebookEntry.stringlookup("Dan"));
    }

}
