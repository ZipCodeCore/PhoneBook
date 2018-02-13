package com.zipcodewilmington.phonebook;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    String name;
    String number;


    private Map<String, String> contactsList;

    public PhoneBook(){
        this.contactsList = new HashMap<String, String>();
        contactsList.put("Pete Jones", "2678849087");
        contactsList.put("Ron Burgundy", "5604329932");
        contactsList.put("Nala Bits", "2345578122");

    }
    public Map<String, String> getContactsList(){
        return contactsList;
    }

    public void addContact(String name, String number) {
        if (!contactsList.containsKey(name)) {
            contactsList.put(name, number);
            System.out.println("New contact " + name + " has been added");
        } else {
            System.out.println("Contact already exists");
        }
    }

    public void removeContact(String name) {
        if (contactsList.containsKey(name)) {
            contactsList.remove(name);
            System.out.println("Contact has been removed");
        } else {
            System.out.println("No " + name + " contact exists");
        }
    }

    public String lookUpContactByName(String name){
        return contactsList.get(name) == null ? "Sorry name not found" : contactsList.get(name);
    }

    public void listAllByName(String name){
        for(String ContactsByName : contactsList.keySet()){
            System.out.println(contactsList.get(name));
        }

    }
    public void listAllNamesAndNumbers(){
        Set<Map.Entry<String, String>>listingAll = contactsList.entrySet();
        System.out.println(contactsList);
    }

}

}
