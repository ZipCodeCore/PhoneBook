import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aurorabanuelos on 5/16/17.
 */


public class PhoneBook {


    TreeMap<String, ArrayList<String>> phoneList = new TreeMap<String, ArrayList<String>>();


    public String lookup(String inputName){

        return inputName + "'s phone number is: "+ phoneList.get(inputName).toString();

    }

    public void addEntry(String inputName, ArrayList<String> inputNumber){

        phoneList.put(inputName, inputNumber);

    }

    public void addToExistingEntry(String inputName, String additionalPhoneNumber){

        phoneList.get(inputName).add(additionalPhoneNumber);
    }

    public String lastPhoneNumberAdded(String inputName){
        String lastPhoneAdded = phoneList.get(inputName).get(phoneList.get(inputName).size()-1);
        return lastPhoneAdded;
    }

    public void removeEntry(String inputName){

        phoneList.remove(inputName);

    }

    public String listAllNames(){

        String allNames = "";

        for(Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()){
            allNames += entry.getKey() + "\n";
        }

        return allNames.trim();

    }

    public String listAllEntries(){

        String allEntries = "";

        for(Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()){
            allEntries += entry.getKey() + ": " + entry.getValue().toString() + "\n";
        }

        return allEntries.trim();

    }

    public String reverseLookup(String inputNumber){

        String name = "";

        for(Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()){
            if(entry.getValue().equals(inputNumber)){
                name = entry.getKey();
            }
        }

        return inputNumber + " belongs to : " + name;

    }


}
