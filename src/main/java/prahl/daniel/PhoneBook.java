package prahl.daniel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by danielprahl on 5/16/17.
 */

public class PhoneBook {
    TreeMap<String, String> record;
    HashMap<String, String> reverseRecord;

    {
        record = new TreeMap<>();
        reverseRecord = new HashMap<>();
    }

    // part 1
    public String lookup(String name){
        return record.get(name);
    }

    public void addEntry(String name, String phoneNumber){
        reverseRecord.put(phoneNumber, name);
        record.put(name, phoneNumber);
    }

    public void removeEntry(String name){
        reverseRecord.remove(record.get(name));
        record.remove(name);
    }
    /*
    public void removeNumber(String name, String phoneNumber){}*/

    public String[] listAllNames(){
        String[] nameList = record.keySet().toArray(new String[0]);
        for (String s: nameList) {System.out.println(s);}
        return nameList;
    }

    public String[] listAllEntries(){
        ArrayList<String> entryList = new ArrayList<>();
        String[] names = record.keySet().toArray(new String[0]);
        for (String s: names) {
            entryList.add(s);
            entryList.add(record.get(s));
        }
        String[] entryArray = entryList.toArray(new String[0]);
        for (String s:entryArray) {System.out.println(s);}
        return entryArray;
    }

    // part 2
    public String reverseLookup(String phoneNumber){
        return reverseRecord.get(phoneNumber);
    }

}
