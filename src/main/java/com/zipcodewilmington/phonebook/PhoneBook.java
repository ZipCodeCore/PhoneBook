package com.zipcodewilmington.phonebook;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    Map<String,String> phoneBook = new TreeMap<String, String>();
    Set<String>names;
    Set<String>phoneBookList;
    String nameLists="";
    String namesAndNumbers ="";


    public PhoneBook(Map<String, String> phoneBook) {
        this.phoneBook = phoneBook;
    }

    public PhoneBook() {

    }

    public void add(String name,String phoneNumber) {

     phoneBook.put(name, phoneNumber);
    }

    public void remove(String name){
        if(phoneBook.containsKey(name)){
            phoneBook.remove(name);
        }
        else{
            System.out.println(name+" does not exist in the phone book list");
        }

    }

        public String lookup(String name){

        return phoneBook.get(name);
        }

        public String listNames(){
        if(phoneBook.isEmpty()){
            return null;
        }else {
            Set<String> names = phoneBook.keySet();

            for (String name : names) {
                nameLists += name + "\n";
            }
            return nameLists;
        }

        }

        public String listNamesAndNumbers(){
            if(phoneBook.isEmpty()){
                return null;
            }else {
                Set<String> PhoneBookList = phoneBook.keySet();
                for (String nameKeys : phoneBookList) {
                    namesAndNumbers += nameKeys + "   " + phoneBook.get(nameKeys) + "\n";
                }
            }

        return namesAndNumbers;
        }



}
