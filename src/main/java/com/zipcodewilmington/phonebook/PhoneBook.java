package com.zipcodewilmington.phonebook;

/**
 * Created by leon on 1/23/18 updated by Joshua Wurdemann 2/12/2018.
 */

import java.util.*;

/**
 * Phone Book
 * add
 * remove
 * lookup
 * listNames
 * ListAll
 * ReverseLookup
 */
public class PhoneBook {

    private TreeMap<String, Person> phoneBook;

    public PhoneBook(TreeMap thisPhone) {
        phoneBook = thisPhone;

    }

    /**
     * might change method Param to an Object.
     *
     * @return
     */
    private boolean add(String name, String phoneNumber) {
        Person somePerson = new Person(name, phoneNumber);
        boolean personAdded = false;

        if(!name.equals(somePerson.getName())){
            phoneBook.put(name, somePerson);
        }
        personAdded = true;

        return personAdded;
    }

    private boolean removeName(String name) {
        if(name.equals(lookUpName(name))){
            phoneBook.remove(name);
        }

        return true;

    }
   public Person lookUpPhoneNumber(String phoneNumber){
       /**reverse lookup need to look value "phoneNumber"*/

       for(Map.Entry<String, Person> entry : phoneBook.entrySet()){
          if(entry.getValue().getNumber().equals(phoneNumber){
              return entry.getValue();
           }
        }
       return null; // change this
   }

    public Person lookUpName(String name) {

       return phoneBook.get(name);
    }

    public String[] getlistAllNames(){

        Set<String> keys = phoneBook.keySet();

        return keys.toArray(new String [keys.size()]);
    }
    public  CogetlistAllPhonebook(){

       Collection value = phoneBook.values();
      return value;
    }
}
