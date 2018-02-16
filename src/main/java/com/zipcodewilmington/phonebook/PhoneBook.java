package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    protected HashMap<String, Person> hashMap;
    protected ArrayList<String> entryList;
    protected Set<String> keySet;

    public PhoneBook() {
        this.hashMap = new HashMap<String, Person>();
        this.entryList = new ArrayList<String>();
        this.keySet = hashMap.keySet();
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

    public Set<String> getKeySet() { //names and phone numbers
        return hashMap.keySet();
        //return all persons
    }

    public StringBuilder displayAllEntries() { //names and phone numbers
        StringBuilder sb = new StringBuilder();

        for (String key : hashMap.keySet()) {
            sb.append(hashMap.get(key).getName() + "\n");
            sb.append(hashMap.get(key).getPhoneNumberListString());
        }

        return sb;
        //call getentries
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

}
