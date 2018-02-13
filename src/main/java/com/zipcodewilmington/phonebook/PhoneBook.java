package com.zipcodewilmington.phonebook;

import java.util.HashMap;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private HashMap<String, Entry> book;
    private int numberOfEntries;

    public PhoneBook() {
        numberOfEntries = 0;
        book = new HashMap<>();
        numberOfEntries = 0;
    }

    /**
     * get the phone number(s) on record for the given name
     * @param name the name for which to search
     * @return the list of phone numbers associated with the given name or an error msg if not found
     */
    public String lookup(String name) {
        if (book.containsKey(name))
            return book.get(name).listNumbers();
        else
            return "[ I have no memory of this person. ]";
    }

    /**
     * get the name of the person on record to whom the given phone number belongs
     * @param number the phone number used as the search parameter
     * @return the person to whom the number belongs or an error msg if the number isn't found
     */
    public String reverseLookup(String number) {
        for (Entry e : book.values()) {
            if (e.listNumbers().contains(number)) {
                return e.getName();
            }
        }
        return "[ She definitely changed her number. ]";
    }

    /**
     * @return  a (somewhat) formatted list of all Entries
     */
    public String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Entry e : book.values())
            sb.append(e.toString());
        return sb.toString();

    }

    /**
     * return the whole list as a JSON string
     * @return a the list. as a JSON string.
     */
    public String listAllJSON() {
        JsonObjectBuilder jb = Json.createObjectBuilder();
        for(Entry e : book.values()) {
            JsonObjectBuilder numJB = Json.createObjectBuilder();
            for(Number n : e.getNumbersaslist()) {
                numJB.add(n.getDescription(), n.getNumber());
            }
            jb.add(e.getName(), numJB.build());
        }
        JsonObject jsonList = jb.build();
        return jsonList.toString();
    }

    /**
     * print a (somewhat) formatted list of all Entries
     */
    public void printAll() {
        System.out.println(listAll());
    }

    /**
     * attempt to remove an Entry by its name
     * @param name the name of the entry to be removed
     * @return the Entry removed or null if none was found
     */
    public Entry removeEntry(String name) {
        return book.remove(name);
    }

    /**
     * attempt to remove a given number from the given Entry name
     * @param name the name of the Entry to be removed
     * @param number the number to remove from the entry
     * @return true if successful
     */
    public boolean removeNumberFromEntry(String name, String number) {
        return book.get(name).remove(number);
    }

    /**
     * add a new entry to the phoneBook. If the Entry exists w/ the given name, add number to existing entry
     * @param name the name of the entry to add/update
     * @param number the phone number to add
     * @return the entry that was updated/added
     */
    public Entry addEntry(String name, String number) {
        Entry e;
        if (book.containsKey(name)) {
            e = book.get(name);
            e.addNumber(number, "secondary");
        }
        else {
            numberOfEntries++;
            e = book.put(name, new Entry(name, number));
        }
        return e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Entry> entry : book.entrySet())
            sb.append(entry.toString());
        return sb.toString();
    }
}
