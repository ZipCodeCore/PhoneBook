package com.zipcodewilmington.phonebook;

import java.util.TreeMap;
import java.util.Set;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

        String name;
        String phonenum;
        TreeMap<String, String> contacts = new TreeMap<String, String>();



public PhoneBook() {
}

 public void add(String name, String phonenum){
       contacts.put(name, phonenum);
 }

 public void deleter(String name){
        contacts.remove(name);
 }

 public String lookup(String name){
        return contacts.get(name);

 }

 public String listNames(){
    StringBuilder namesnumbers = new StringBuilder();
        Set<String> keys = contacts.keySet();
        for(String key: keys)

        {

            namesnumbers.append(key+"\n");
        }
        return namesnumbers.toString();
 }

    public String listNamesAndNumbers(){
        StringBuilder namesnumbers = new StringBuilder();
        Set<String> keys = contacts.keySet();
        for(String key: keys)

        {

            namesnumbers.append(key+" "+contacts.get(key)+"\n");
        }
        return namesnumbers.toString();
    }


}
