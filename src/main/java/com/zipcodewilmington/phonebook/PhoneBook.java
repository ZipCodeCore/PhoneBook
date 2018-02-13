package com.zipcodewilmington.phonebook;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    //instance variable
    private TreeMap<String, String> treeMap;

    // void "no arguments" constructor -creates empty map
    public PhoneBook() {
        this.treeMap= new TreeMap<String, String>();
    }

    // single argument constructor -type Map -creates new map w/ same key/value mappings as argument
    public PhoneBook(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

    //add a name & number entry
    public void add(String name, String number) {
        treeMap.put(name, number);
        String confirm = "";
        if(treeMap.put(name, number)!= null) {
            confirm = name + " and " + number + " are now in the database";
        } else {
            confirm = "Error: " + name + " is already in the database";
        }
    }

    //remove a name & number entry
    public String remove(String name) {
        treeMap.remove(name);
        String response = "";
        if(treeMap.remove(name) != null) {
            response = "Name and number removed";
        }
        if(treeMap.remove(name)== null) {
            response = "Invalid entry";
        }
        return response;
    }

    //find phone number lookup by name
    public String lookup(String name) {
         String lookup = treeMap.get(name);
         String notFound = name + " is not in the directory";
         if(lookup != null) {
             return lookup;
         }
         else {
             return notFound;
         }
    }

    //print out all of the entries in PhoneBook
    //need to work on code for formatting
    public String display() {
        System.out.println(treeMap.entrySet().toString());
        String printOut = treeMap.entrySet().toString();
        return printOut;
    }



}

