package com.zipcodewilmington.phonebook;
import java.util.*;

/**
 * Created by leon on 1/23/18.
 */

//Class Declaration
public class PhoneBook {
    //method 1
    private static final String NON_EXISTANT_MESSAGE = "This does not exist.";

    private TreeMap<String, String> contacts;

    public PhoneBook() {
        contacts = new TreeMap<>();
    }


    public void add (String name, String phoneNumber) {
        contacts.put(name, phoneNumber);
    }

    public String lookup(String name) {
        return contacts.get(name);

    }

    public void remove (String name) {
        contacts.remove(name);
    }

    public String display() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, String> entry : contacts.entrySet()) {
            String name = entry.getKey();
            String phoneNumber = entry.getValue();
            sb.append(name + " " + phoneNumber + "\n");
        }
        return sb.toString();
    }
    //
//    public String reverseLookUp (String phoneNumber){
//        if (this.contacts.containsValue(phoneNumber)){
//            String name = "";
//            for(Map.Entry<String, String> entry : this.contacts.entrySet()){
//                if (entry.getValue().equals(phoneNumber)) {
//                    return entry.getKey();
//                }
//            }
//            return name;
//        }
//        else {
//            return NON_EXISTANT_MESSAGE;
//        }
//
//    }
//
//    public void add (String name, String phoneNumber){
//        this.contacts.put(name, phoneNumber);
//
//    }
//
//    public void remove (String name, String phoneNumber) {
//        this.contacts.remove(name, phoneNumber);
//    }
//
//   public Set listNames () {
//        return this.contacts.keySet();
//   }
//    public Set listNameNumber () {
//      //loop through  return this.contacts.values();
//        return this.contacts.entrySet();
//
//    }





}
