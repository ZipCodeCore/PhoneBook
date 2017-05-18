package holdingObjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * Created by mattwu on 5/16/17.
 */
public class PhoneBookManager {

    Map<String, ArrayList<String>> phoneBook = new TreeMap<String, ArrayList<String>>();

    public int size(){

        return phoneBook.size();
    }

    public String lookup(String name) throws RecordNotPresent{

        if(!phoneBook.containsKey(name)) {
            throw new RecordNotPresent();
        }

        return name + ": " + phoneBook.get(name);
    }


    public void addEntry(String name, String phoneNumber) throws InvalidPhoneNumberFormatException{

        if (!phoneNumber.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
                throw new InvalidPhoneNumberFormatException();
        }

        ArrayList<String> pb = new ArrayList<String>();
        pb.add(phoneNumber);
        phoneBook.put(name, pb);
    }


    public void removeEntry(String name)  throws RecordNotPresent{

        if(!phoneBook.containsKey(name)) {
            throw new RecordNotPresent();
        }
        phoneBook.remove(name);

    }

    public String showAllEntries(){

        String allEntries = "";

        for(Map.Entry p: phoneBook.entrySet()){
            allEntries += "\n\n" + p.getKey() + "\n" + p.getValue();
        }

        return allEntries;
    }

    public String reverseLookup(String number) throws InvalidPhoneNumberFormatException, RecordNotPresent {

        if (!number.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }

        //looking every set within the phoneBook treeMap
        for(Map.Entry<String, ArrayList<String>> entry : phoneBook.entrySet()){

            //now its in the set, and looking for the String phoneNum within the arrayList
            for(String phoneNum : entry.getValue()){
                if(phoneNum.equals(number)){
                    return entry.getKey();
                }
            }
        }

        throw new RecordNotPresent();

    }

    public void addToExistingEntry(String existingName, String additionalNumber) throws InvalidPhoneNumberFormatException, RecordNotPresent{

        if (!additionalNumber.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }

        if(!phoneBook.containsKey(existingName)) {
            throw new RecordNotPresent();
        }

        phoneBook.get(existingName).add(additionalNumber);

    }

    public void removeOneNumberFromEntry(String existingName, String numberToBeRemove) throws InvalidPhoneNumberFormatException, RecordNotPresent{

        if (!numberToBeRemove.matches("\\(\\d{3}\\)\\d{3}-\\d{4}")) {
            throw new InvalidPhoneNumberFormatException();
        }

        if(!phoneBook.containsKey(existingName)) {
            throw new RecordNotPresent();
        }

        phoneBook.get(existingName).remove(numberToBeRemove);
    }




}
