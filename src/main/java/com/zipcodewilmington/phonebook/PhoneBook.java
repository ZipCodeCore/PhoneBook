package com.zipcodewilmington.phonebook;
import java.util.TreeMap;
/**
 * Created by leon on 1/23/18.
 */

//Class Declaration
public class PhoneBook {
    //method 1
    private static final String NON_EXISTANT_MESSAGE = "This number does not exist.";

    private TreeMap<String, String> contacts;

    public PhoneBook() {
        this.contacts = new TreeMap<>();
    }


    public String lookUpPhoneNumber(String name){
        if (this.contacts.containsKey(name)){
            return this.contacts.get(name);
        }
        else {
            return NON_EXISTANT_MESSAGE;
        }
    }

    public String lookUpName (String phoneNumber){
        if (this.contacts.containsValue(phoneNumber)){
            return this.contacts.get(phoneNumber);
        }
        else {
            return NON_EXISTANT_MESSAGE;
        }

    }

    public void add (String name, String phoneNumber){
        this.contacts.put(name, phoneNumber);

    }

    public void remove (String name, String phoneNumber) {
        this.contacts.remove(name, phoneNumber);
    }

    public String listAllNames () {
      //loop through  return this.contacts.values();
        return null;
    }

    public static void main(String[] args) {

        PhoneBook pb = new PhoneBook();
        pb.add("Joe", "123455789");
        System.out.println(pb.lookUpPhoneNumber("Joe"));

    }


}
