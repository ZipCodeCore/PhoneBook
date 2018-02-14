package com.zipcodewilmington.phonebook;

import java.util.*;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private String name;
    private String number;

    TreeMap<String, ArrayList<String>> myTree = new TreeMap<String, ArrayList<String>>();


    public PhoneBook(){

    }


    public void addEntry(String name, String... number) {
        ArrayList<String> listOfPhoneNumbers = new ArrayList<String>(Arrays.asList(number));
        myTree.put(name, listOfPhoneNumbers);

    }

    public void additionalPhoneNumberToKey(String name, String number) {
        myTree.get(name).add(number);
    }


    public void removeNumberFromName(String name, String number) {
        myTree.get(name).remove(number);
    }


    public void removeEntry(String name) {
        myTree.remove(name);

    }

    public String lookupNumber(String name) {
        ArrayList<String> matchingNumbers = myTree.get(name);
        String listedNumbers = "";
        for (String phoneNumbers : matchingNumbers) {
            listedNumbers +=phoneNumbers + "\n";
        }
       return listedNumbers.trim();


    }

    public String listNames() {

        Set<String> contacts = myTree.keySet();

        String allNames = "";
        for (String contact : contacts) {
            allNames += contact + "\n";

        }
        return allNames.trim();
    }

    public String listPhoneBook() {

        Set<String> contacts = myTree.keySet();
        StringBuilder printBook = new StringBuilder();

        for (String name : contacts) {
            printBook.append(name).append(": ");
            for (int x = 0; x<myTree.get(name).size(); x++) {
                printBook.append(x).append("  ");
            } printBook.append("\n");

        }
        String result = printBook.toString();

        return result;
    }

    public String reverseLookup(String number) {

        Set<String> contacts = myTree.keySet();

        for (String name : contacts) {
            for (int y = 0; y < myTree.get(name).size(); y++) {
                if (myTree.get(name).get(y).equals(number)) {
                    return name;
                }
            }
        }


        return "not in my phone book";

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
