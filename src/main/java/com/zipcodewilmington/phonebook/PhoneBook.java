package com.zipcodewilmington.phonebook;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook{

    private String name;
    private String number;

    public PhoneBook (){

    }

    TreeMap<String, String> actualPhoneBook = new TreeMap<String , String>();

    public void add(String name, String number){

        actualPhoneBook.put(name, number);

    }

    public String lookUp(String name){

       return actualPhoneBook.get(name);

    }

    public void remove(String name){
        actualPhoneBook.remove(name);

    }

    public String[] listName(){
        Set<String> names = actualPhoneBook.keySet();
        return names.toArray(new String[names.size()]);
    }

    public String listNameAndNumbers(){

        StringBuilder listNameAndNumbers = new StringBuilder();

        for (Map.Entry<String, String> entry : actualPhoneBook.entrySet()) {

            String getKeys = entry.getKey();
            String getValues = entry.getValue();

           listNameAndNumbers.append(getKeys).append(": ").append(getValues).append("\n");
        }
        String listAll = listNameAndNumbers.toString();
        return listAll;
    }

}
