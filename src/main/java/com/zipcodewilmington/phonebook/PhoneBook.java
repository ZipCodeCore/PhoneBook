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
        if(!treeMap.containsKey(name)) {
            treeMap.put(name, number);
        }
    }

    //remove a name & number entry
    public void remove(String name) {
        if(treeMap.containsKey(name)) {
            treeMap.remove(name);
        }
    }

    //find phone number lookup by name
    public void lookup(String name) {
        if(treeMap.containsKey(name)) {
            treeMap.get(name);
        }

    }

    //print out all of the entries in PhoneBook
    //need to work on code for formatting
    public String display(){
        String printOut = "";
        for(Map.Entry<String, String> entry: treeMap.entrySet()) {
            printOut += entry.getKey() + " " + entry.getValue() + "\n";
        }
        System.out.println(printOut);
        return printOut;
    }



}

