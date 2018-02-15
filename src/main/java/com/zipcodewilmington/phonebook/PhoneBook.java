package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private TreeMap<String String> contacts;

    public PhoneBook() {

        contacts = new TreeMap<>();
    }
    public void add (String name, String number){
        contacts.put(name, number);
    }
    public String lookup (String name){
        return contacts.get(name);
    }
    public void remove (String name){
        contacts.remove(name);
    }
    public String display (){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String>entry : contacts.entrySet()){
            String name = entry.getKey();
            String number = entry.getValue();
            sb.append(name + "     " + number + "\n");
        }
        return sb.toString();
    }
    public String reverseLookup (String number){
        for (Map.Entry <String, String>entry: contacts.entrySet()){
            if (entry.getValue().equals(number){
            }
            return null;
        }
    }






















    public void addAContact(String name, String number) {
        tmap.put(name, number);
    }

    public String listOfAllNames(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> entry: tmap.entrySet()){
            result.append(String.format("%-20s %8s\n", entry.getKey(), entry.getValue()));
            //formats the way a string will print out on console^^^^^^
        }
        return String.valueOf(result);
    }

    public void removeAContact(String name) {
        tmap.remove(name);
    }

    public String lookupContactName(String name) {
        if (tmap.containsKey(name)) {
            return tmap.get(name);
        } else {
            return "This Name Does Not Exist";
        }
    }



    public reverseLookUpNumber (String number){

        }


}



