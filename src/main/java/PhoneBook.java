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


    public String lookup(String inputName) throws RecordNotPresent {

        if(phoneList.get(inputName).equals(null)) {
            throw new RecordNotPresent("Name does not exist in phonebook");
        }

            String phoneNumsString = phoneList.get(inputName).toString();
            phoneNumsString = phoneNumsString.substring(1, phoneNumsString.length() - 1);

            return inputName + "'s phone number is: " + phoneNumsString;

    }

    public void addEntry(String inputName, ArrayList<String> inputNumber) throws InvalidPhoneNumberFormatException {
        for (String inputs : inputNumber) {
            if (!inputs.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
                throw new InvalidPhoneNumberFormatException("Phone number format should be formatted as (###)-###-####");
            }
        }
        phoneList.put(inputName, inputNumber);
    }

    public void addToExistingEntry(String inputName, String additionalPhoneNumber) throws InvalidPhoneNumberFormatException, RecordNotPresent {

        if (phoneList.get(inputName).equals(null)){
            throw new RecordNotPresent("Name does not currently exist in phonebook");
        }

        if(!additionalPhoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            throw new InvalidPhoneNumberFormatException("Phone number format should be formatted as (###)-###-####");
        }

        phoneList.get(inputName).add(additionalPhoneNumber);
    }

    public String lastPhoneNumberAdded(String inputName) throws RecordNotPresent {
        if(phoneList.get(inputName).equals(null)){
            throw new RecordNotPresent("Name does not exist in phonebook");
        }
        String lastPhoneAdded = phoneList.get(inputName).get(phoneList.get(inputName).size() - 1);
        return lastPhoneAdded;
    }

    public void removeRecord(String inputName) throws RecordNotPresent {

//        if(phoneList.get(inputName).equals(null)){
//            throw new RecordNotPresent("Cannot remove, Name does not exist in phonebook");
//        }

            phoneList.remove(inputName);

    }

    public void removeOnePhoneNumberFromEntry(String inputName, String phoneNumberToBeRemoved) throws InvalidPhoneNumberFormatException, RecordNotPresent {

        if(phoneList.get(inputName).equals(null)){
            throw new RecordNotPresent("Name does not exist in phonebook");
        }

        if(!phoneNumberToBeRemoved.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            throw new InvalidPhoneNumberFormatException("Phone number format should be formatted as (###)-###-####");
        }


        for (String phoneNum : phoneList.get(inputName)) {
            if (phoneNum.equals(phoneNumberToBeRemoved)) {
                phoneList.get(inputName).remove(phoneNum);
            }
        }
    }

    public boolean isPhoneNumberListed(String inputName, String phoneNumberToBeChecked) throws InvalidPhoneNumberFormatException, RecordNotPresent {

        if(phoneList.get(inputName).equals(null)){
            throw new RecordNotPresent("Name does not exist in phonebook");
        }

        if(!phoneNumberToBeChecked.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            throw new InvalidPhoneNumberFormatException("Phone number format should be formatted as (###)-###-####");
        }

        for (String phoneNum : phoneList.get(inputName)) {
            if (phoneNum.equals(phoneNumberToBeChecked)) {
                return true;
            }
        }
        return false;
    }

    public String listAllNames() {

        String allNames = "";

        for (Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()) {
            allNames += entry.getKey() + "\n";
        }

        return allNames.trim();

    }

    public String listAllEntries() {

        String allEntries = "";

        for (Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()) {

            String phoneNumsString = entry.getValue().toString();
            phoneNumsString = phoneNumsString.substring(1, phoneNumsString.length() - 1);

            allEntries += entry.getKey() + ": " + phoneNumsString + "\n";
        }

        return allEntries.trim();

    }

    public String reverseLookup(String inputNumber) throws InvalidPhoneNumberFormatException, RecordNotPresent {

        if(!inputNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            throw new InvalidPhoneNumberFormatException("Phone number format should be formatted as (###)-###-####");
        }

        for (Map.Entry<String, ArrayList<String>> entry : phoneList.entrySet()) {
            for (String phoneNum : entry.getValue()) {
                if (phoneNum.equals(inputNumber)) {
                    return inputNumber + " belongs to : " + entry.getKey();
                }
            }
        }

        throw new RecordNotPresent("Number does not exist in phonebook");

    }


}
