package holdingObjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * Created by mattwu on 5/16/17.
 */
public class PhoneBookManager {


    Map<String, String> phoneBook = new TreeMap<String, String>();


    public int size(){

        return phoneBook.size();
    }



    public String lookup(String name){

        return phoneBook.get(name);
    }

    public String add(String name, String phoneNumber){

        phoneBook.put(name , phoneNumber);
        return name + " " + phoneNumber + " has added to Phone Book";
    }

    public String remove(String name){

        phoneBook.remove(name);
        return name + " has removed from Phone Book";
    }

    public String showAllEntires(){

        String allEntries = "";

        for(Map.Entry p: phoneBook.entrySet()){
            allEntries += "\n\nName: " + p.getKey() + "\nPhoneNumbers: " + p.getValue();
        }

        return "All Entries are Below" + allEntries;
    }


}
