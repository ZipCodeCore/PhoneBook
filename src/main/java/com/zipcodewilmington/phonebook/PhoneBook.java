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
    public String remove(String name) {
        String removeName = name + " " + treeMap.get(name) + " has been removed";
        if(treeMap.containsKey(name)) {
            treeMap.remove(name);
        }
        return removeName;
    }

    //find phone number lookup by name
    public String lookup(String name) {
        String number = treeMap.get(name);
        return number;
    }

    //print out all of the entries in PhoneBook
    //need to work on code for formatting

    public String display(){
        StringBuilder printOut = new StringBuilder();
        for(Map.Entry<String, String> entry: treeMap.entrySet()) {
            printOut
                    .append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }
        String print = printOut.toString();
        System.out.println(printOut);
        return print;
    }



}

