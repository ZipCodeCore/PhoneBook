package com.zipcodewilmington.phonebook;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

//phoneBook class is like the cover of the book.
public class PhoneBook {

    public static void main(String[] args) {

        PhoneBook myPhoneBookActualObjectInstance= new PhoneBook();
        myPhoneBookActualObjectInstance.add("vince", "1123456789");
        myPhoneBookActualObjectInstance.add("amy", "29387429");
        System.out.println(myPhoneBookActualObjectInstance.displayEntirePhoneBookContents());
    }


    /*the treeMap is like the t structure with key/values. key is person's name in this example, value is the arraylist
    which can hold multiple numbers, fields etc.
    */
    TreeMap<String, Person> personTreeMap = new TreeMap<String, Person>();

    public PhoneBook() {

    }

    public void add(String name, String number) {
        Person phoneBookEntry = new Person(name, number);
        personTreeMap.put(name, phoneBookEntry);
    }


    public void remove(String name) {

        personTreeMap.remove(name);
    }

    public String lookup(String name) {

        return personTreeMap.get(name).getNumbers();

    }

    public String reverseLookup(String number) {

        return

    }

    public String showNamesOnly() {

        String phoneListOfNamesOnly= "";
        Set<String> nameTreeKeys = personTreeMap.keySet();
        for (String personsName : nameTreeKeys) {
            phoneListOfNamesOnly += (personsName + "\n");
            }

        return phoneListOfNamesOnly;

        }

    public String displayEntirePhoneBookContents() {

        String entirePhoneBook = "";
        Set<String> nameTreeKeys = personTreeMap.keySet();
        for (String personsName : nameTreeKeys) {
             entirePhoneBook += (personsName + "'s phone number: " +  personTreeMap.get(personsName).getNumbers() + "\n");
        }

        return entirePhoneBook;

        }

    }


