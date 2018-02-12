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
    public void addNameNumberEntry(String name, String number) {
        treeMap.put(name, number);
    }

    //remove a name & number entry
    public void removeEntry(String name) {
        treeMap.remove(name);
    }

    //find phone number lookup by name
    public String lookupByName(String name) {
         return treeMap.get(name);
    }

    //print out all of the entries in PhoneBook
    public Set<Map.Entry<String,String>> printOutPhoneBook() {
        return treeMap.entrySet();
    }



}
