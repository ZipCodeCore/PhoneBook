package com.zipcodewilmington.phonebook;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    //instance variable
    private TreeMap<String, ArrayList<String>> treeMap;


    // void "no arguments" constructor -creates empty map
    public PhoneBook() {
        this.treeMap= new TreeMap<String, ArrayList<String>>();
    }

    // single argument constructor -type Map -creates new map w/ same key/value mappings as argument
    public PhoneBook(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

    //add a name & number entry, add number
    public void addEntry(String name, ArrayList<String> number) {
        if (!treeMap.containsKey(name)) {
            treeMap.put(name, number);
        }
    }

    //add numbers to existing entries
    public void addNumberToEntry(String name, String number) {
        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
            if (name.equals(entry.getKey())) {
                ArrayList<String> value = entry.getValue();
                value.add(number);
            }
        }
    }

    //remove numbers from existing entries
    public void removeNumberFromEntry(String name, String number) {
        for (Map.Entry<String, ArrayList<String>> entry : treeMap.entrySet()) {
            if (entry.getKey().equals(name)) {
                if (entry.getValue().contains(number)) {
                    entry.getValue().remove(number);
                }
            }
        }
    }

    //remove entire entry
    public void removeEntry(String name) {
            treeMap.remove(name);
    }

    //lookup: find phone number from name
    public ArrayList<String> lookup(String name) {
        return treeMap.get(name);
    }

    //reverse lookup: find name from number
    public String reverseLookup (String number) {
        String name = "";
        for(Map.Entry<String, ArrayList<String>> entry: treeMap.entrySet()) {
            ArrayList<String> value = entry.getValue();
            for(String revnumber: value) {
                if(number.contains(revnumber)) {
                    name = entry.getKey();
                }
            }
        }
        return name;
    }

    //print out all of the entries in PhoneBook
    public String display(){
        StringBuilder printOut = new StringBuilder();
        for(Map.Entry<String, ArrayList<String>> entry: treeMap.entrySet()) {
            printOut.append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue().toString())
                    .append("\n");
        }
        return printOut.toString();
    }

}
