package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;


    public PhoneBook() {

    }

    TreeMap<String, ArrayList<String>> actualPhoneBook = new TreeMap<String, ArrayList<String>>();

    public void add(String name, String... numbers) {

        ArrayList<String> numberList = new ArrayList<String>();

        for (String number : numbers) {

            numberList.add(number);

        }

        actualPhoneBook.put(name, numberList);

    }

    public ArrayList<String> lookUp(String name) {

        return actualPhoneBook.get(name);

    }

    public void remove(String name) {
        actualPhoneBook.remove(name);

    }

    public String[] listName() {
        Set<String> names = actualPhoneBook.keySet();
        return names.toArray(new String[names.size()]);
    }

    public String listNameAndNumbers() {

        StringBuilder listNameAndNumbers = new StringBuilder();

        for (Map.Entry<String, ArrayList<String>> entry : actualPhoneBook.entrySet()) {

            String getKeys = entry.getKey();
            List getValues = entry.getValue();

            listNameAndNumbers.append(getKeys).append(": ").append(getValues).append("\n");
        }
        String listAll = listNameAndNumbers.toString();
        return listAll;
    }

    public String reverseLookUp(String number) {

        for (Map.Entry entry : actualPhoneBook.entrySet()) {
            String reverse = "";
            if (number.equals(entry.getValue())) {
                reverse = entry.getKey().toString();
            }
            return reverse;
        }
        return null;
    }

}
