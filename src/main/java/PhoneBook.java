import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by aurorabanuelos on 5/16/17.
 */


public class PhoneBook {

    TreeMap<String, String> phoneList = new TreeMap<String, String>();


    public String lookup(String inputName){

        return inputName + "'s phone number is: "+ phoneList.get(inputName);

    }

    public void addEntry(String inputName, String inputNumber){

        phoneList.put(inputName, inputNumber);

    }

    public void removeEntry(String inputName){

        phoneList.remove(inputName);

    }

    public String listAllNames(){

        String allNames = "";

        for(Map.Entry<String, String> entry : phoneList.entrySet()){
            allNames += entry.getKey() + "\n";
        }

        return allNames.trim();

    }

    public String listAllEntries(){

        String allEntries = "";

        for(Map.Entry<String, String> entry : phoneList.entrySet()){
            allEntries += entry.getKey() + ": " + entry.getValue() + "\n";
        }

        return allEntries.trim();

    }

    public String reverseLookup(String inputNumber){

        String name = "";

        for(Map.Entry<String, String> entry : phoneList.entrySet()){
            if(entry.getValue().equals(inputNumber)){
                name = entry.getKey();
            }
        }

        return inputNumber + " belongs to : " + name;

    }


}
