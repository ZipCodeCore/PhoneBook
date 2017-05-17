package prahl.daniel;

import java.util.*;

/**
 * Created by danielprahl on 5/16/17.
 */

public class PhoneBook {
    private Map<String, ArrayList<String>> record;
    private Map<String, String> reverseRecord;

    // static initialization block
    {
        record = new TreeMap<>();
        reverseRecord = new HashMap<>();
    }

    public List<String> lookup(String name){
        return record.get(name);    // return the list of all phone numbers associated with given name
    }

    public void addEntry(String name, String phoneNumber) throws NumberFormatException{
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {   // verify correct input format
            throw new NumberFormatException();
        }
        reverseRecord.put(phoneNumber, name);               // add to reverse lookup record, and...
        if(!record.containsKey(name)) {             // if main record does not have this name already
            record.put(name, new ArrayList<>());    // create as a new entry
        }                                           // now that an entry has been confirmed or created...
        record.get(name).add(phoneNumber);          // add new phone number to entry
    }

    public void removeRecord(String name){
        for (String s: lookup(name)) {  // for each phone number listed under this name
            reverseRecord.remove(s);    // remove associated entry from reverse lookup list
        }                           // and...
        record.remove(name);            // also remove entire entry from main record
    }

    public void removeNumber(String name, String phoneNumber){
        if(reverseRecord.get(phoneNumber).equalsIgnoreCase(name)) { // check if number is associated with name
            reverseRecord.remove(phoneNumber);                      // if so, remove from reverse record
        }                                                       // and...
        if(record.get(name).contains(phoneNumber)){         // check if number exists in order to proceed
            ArrayList<String> tempList = record.get(name);  // store all numbers associated with this name
            record.remove(name);                            // clear the entry entirely
            for (String s: tempList) {                      // check each number that WAS associated with this name
                if(s != phoneNumber){                       // if not the number being removed...
                    addEntry(name, s);                      // add back into entry in main record
                }
            }
        }
    }

    public List<String> listAllNames(){
        String[] nameList = record.keySet().toArray(new String[0]); // create array of all names in main record
        ArrayList<String> names = new ArrayList<>();                // create arraylist to store array contents
        for (String s: nameList) {                                  // for each name in the array...
            names.add(s);                                           // add name to arraylist
            System.out.println(s);                                  // and print each name to console
        }
        return names;                                               // return populated arraylist
    }

    public List<String> listAllEntries(){
        ArrayList<String> entryList = new ArrayList<>();        // create arraylist to store all main record entries
        String[] names = record.keySet().toArray(new String[0]);// create array of all names in main record
        for (String s: names) {                                 // for each name in the array...
            entryList.add(s);                                   // add name to arraylist
            System.out.println(s);                              // and print each name to console
            for (String str: record.get(s)) {                   // for each phone number associated with each name...
                entryList.add(str);                             // add phone number to arraylist
                System.out.println(str);                        // and print each number to console
            }
        }
        return entryList;                                       // return populated arraylist
    }

    public String reverseLookup(String phoneNumber) throws NumberFormatException{
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            throw new NumberFormatException();
        }
        return reverseRecord.get(phoneNumber);
    }

}
