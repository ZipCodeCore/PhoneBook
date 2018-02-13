package com.zipcodewilmington.phonebook;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String number;

    TreeMap<String, String> myTree = new TreeMap<String, String>();


    public PhoneBook(){

    }


    public void addEntry(String name, String number) {
        myTree.put(name, number);


    }


    public void remove(String name) {
        myTree.remove(name);

    }

    public String stringLookup(String name) {

       return myTree.get(name);



    }

    public String listNames() {



        Set<String> contacts = myTree.keySet();

        String allNames = "";
        for (String contact : contacts) {
            allNames += contact + "\n";

        }
        return allNames;
    }

    public String listPhoneBook() {


        String allInfo = "";

        for (Map.Entry<String, String> entry: myTree.entrySet()){
            String getKeys = String.format("%1$-15s", entry.getKey());
            String getValues = String.format("%1$-15s", entry.getValue());

            allInfo += getKeys + getValues + "\n";
        }

        return allInfo;
    }


    public static void main(String[] args) {

        PhoneBook phonebookEntry = new PhoneBook();

        phonebookEntry.addEntry("Brian", "3027619121");
        phonebookEntry.addEntry("Dan", "4846394190");
        phonebookEntry.addEntry("Garret", "3027894586");
        phonebookEntry.addEntry("Luke", "3147619121");
        phonebookEntry.addEntry("Kate", "4899994190");
        phonebookEntry.addEntry("Lenore", "3097894586");




        phonebookEntry.listPhoneBook();
        System.out.println(phonebookEntry.listPhoneBook());

    }

}
