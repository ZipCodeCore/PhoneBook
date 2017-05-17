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

        String phoneNumsString = phoneList.get(inputName).toString();
        phoneNumsString = phoneNumsString.substring(1, phoneNumsString.length()-1);


        return inputName + "'s phone number is: "+ phoneNumsString;

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

    public void removeRecord(String inputName){

        phoneList.remove(inputName);

    }

    public void removeOnePhoneNumberFromEntry(String inputName, String phoneNumberToBeRemoved){

        for(String phoneNum : phoneList.get(inputName)){
            if(phoneNum.equals(phoneNumberToBeRemoved)){
                phoneList.get(inputName).remove(phoneNum);
            }
        }
    }

    public boolean isPhoneNumberListed(String inputName, String phoneNumberToBeChecked){
        for(String phoneNum : phoneList.get(inputName)){
            if(phoneNum.equals(phoneNumberToBeChecked)){
                return true;
            }
        }
        return false;
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

            String phoneNumsString = entry.getValue().toString();
            phoneNumsString = phoneNumsString.substring(1, phoneNumsString.length()-1);

            allEntries += entry.getKey() + ": " + phoneNumsString + "\n";
        }

        return allEntries.trim();

    }

    public String reverseLookup(String inputNumber){

        for(Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()){
            for(String phoneNum : entry.getValue()){
                if(phoneNum.equals(inputNumber)){
                    return inputNumber + " belongs to : " + entry.getKey();
                }
            }
        }

        return null;

    }


}
