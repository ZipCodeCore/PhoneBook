package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private LinkedHashMap <String, List<String>> map;


    //THE KEY IS NAME THE VALUE IS THE PHONE NUMBERS
    //THE ARRAY LIST IS PART OF THE (HASH)MAP


    public PhoneBook(LinkedHashMap<String, List<String>> map) {
        this.map = map;
    }

    public PhoneBook() {

        this.map = new LinkedHashMap<>(0);
    }

    public void add(String name, String phoneNumber) {

        if(this.map.containsKey(name)) {
            this.map.get(name).add(phoneNumber);
        } else {
            this.map.put(name, new ArrayList<>());
            this.map.get(name).add(phoneNumber);
        }


       // map.put(name, Arrays.asList(phoneNumber));


//        ArrayList<String> numbers;
//        if(this.map.containsKey(name)){
//           numbers = map.get(name);   //pulls out and returns the value for the key "name" in the ArrayList of existing phone numbers
//            numbers.add(phoneNumber); }  //adds the phone number to the array List
//        else
//        {
//             numbers = new ArrayList<>(Arrays.asList(phoneNumber)); //If the key isn't there we create a new ArrayList key for it
//        }
//        map.put(name, numbers);        //puts the new information into the map
    }

    public void addAll(String name, String... phoneNumbers) {
        if(this.map.containsKey(name)) {
            this.map.get(name).addAll(Arrays.asList(phoneNumbers));
        } else {
            this.map.put(name, Arrays.asList(phoneNumbers));
        }


        //adds many phone numbers to a single name entry
        //map.put(name, Arrays.asList(phoneNumbers));

//        ArrayList<String> numbers;
//
//            numbers = map.getOrDefault(name, new ArrayList <String>());      //pulls out the ArrayList of existing phone numbers
//            ArrayList<String> incomingNums = new ArrayList<>(Arrays.asList(phoneNumbers));  //turns the regular Array of incoming phone numbers to an array List
//            numbers.addAll(incomingNums);
//
//        map.put(name, numbers);
    }

    public void remove(String name) {
        this.map.remove(name);
    }

    public Boolean hasEntry(String name) {
        return map.containsKey(name);
    }

    public List<String> lookup(String name) {
        return map.get(name);
    }

    public String reverseLookup(String phoneNumber) {

        String nameToFind = "";
        for (Map.Entry<String, List<String>> entry : this.map.entrySet()) {
            List<String> listOfPhoneNumbers = map.get(entry.getKey());
            for (int i = 0; i < listOfPhoneNumbers.size(); i++) {
                if (listOfPhoneNumbers.get(i).equals(phoneNumber)) {
                    nameToFind = entry.getKey();
                }
            }
        }
        return nameToFind;
    }

    public List<String> getAllContactNames() {

        List<String> result = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry: map.entrySet()) {
            result.add(entry.getKey());
        }
        return result;
    }

    public Map<String, List<String>> getMap() {

        return this.map;
    }
}
