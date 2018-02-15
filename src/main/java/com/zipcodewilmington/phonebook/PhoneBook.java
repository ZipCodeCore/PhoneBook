package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    protected HashMap<String, Person> hashMap;
    protected ArrayList<String> entryList;

    public PhoneBook() {
        this.hashMap = new HashMap<String, Person>();
        this.entryList = new ArrayList<String>();
        //this.hashMap.put("Name_empty", new Person("Name_empty", "Phone_number_empty"));
    }

    //PART I
    public Person lookup(String name) {
        return hashMap.get(name);
    }

    public void addEntry(String name, String... phoneNumbers) {
        hashMap.put(name, new Person(name, phoneNumbers));
    }

    // Changed method name for Part III
    public void removeRecord(String name) {
        hashMap.remove(name);
    }

    /*
    public ArrayList<String> getEntryList() { //names
        for (Map.Entry<String, Person> entry: hashMap.entrySet()) {
            entryList.add(entry.getKey() + " : " + entry.getValue().getPhoneNumber());
        }
        return entryList;
    }
    */

    public String[] entriesList() { //names and phone numbers
        return new String[0];
    }

    //PART II
    public String reverseLookup(String phoneNumber) { //lookup names from phone numbers
        for (String name : hashMap.keySet()) {
            if (hashMap.get(name).phoneNumberList.contains(phoneNumber) == true) {
                return name;
                //break;
            }
        }
        return "No_name";
    }

    //PART III
    //after I'm done w/ Part I and Part II


}
