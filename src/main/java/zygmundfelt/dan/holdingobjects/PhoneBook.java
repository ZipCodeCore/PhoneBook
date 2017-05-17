package zygmundfelt.dan.holdingobjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    Map<String,ArrayList<String>> map;

    PhoneBook() {
        map = new TreeMap<String,ArrayList<String>>();
    }

    private String validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}")) {   // Valid phone number
            return phoneNumber;
        }
        try {
            Long.parseLong(phoneNumber);
        } catch (Exception e) {
            throw new InvalidPhoneNumberFormatException();
        }
        return buildPhoneNumber(phoneNumber);
    }

    private String buildPhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if(phoneNumber.length() != 10 || phoneNumber.charAt(0) == 0){
            throw new InvalidPhoneNumberFormatException();
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(phoneNumber.charAt(0));
        sb.append(phoneNumber.charAt(1));
        sb.append(phoneNumber.charAt(2));
        sb.append(") ");
        sb.append(phoneNumber.charAt(3));
        sb.append(phoneNumber.charAt(4));
        sb.append(phoneNumber.charAt(5));
        sb.append("-");
        sb.append(phoneNumber.charAt(6));
        sb.append(phoneNumber.charAt(7));
        sb.append(phoneNumber.charAt(8));
        sb.append(phoneNumber.charAt(9));

        return sb.toString();
    }

    ArrayList<String> lookUp(String name) throws RecordNotPresentException{
        ArrayList<String> result = map.get(name);
        if(result == null) {
            throw new RecordNotPresentException();
        }
        return result;
    }

    /*
    Helper method for addRecord.
     */
    private ArrayList<String> createNewRecord(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {
        validatePhoneNumber(phoneNumber);
        ArrayList<String> list = new ArrayList<String>();
        list.add(phoneNumber);
        return map.put(name, list);
    }

    /*
    Not sure if it'd be better to switch the blocks in if and else.
     */
    ArrayList<String> addRecord(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {
        if(map.get(name) == null) {
            return createNewRecord(name, phoneNumber);
        } else {
            map.get(name).add(phoneNumber);
            return map.get(name);
        }
    }

    ArrayList<String> addRecords(String name, String... phoneNumbers) throws InvalidPhoneNumberFormatException {
        for(String s : phoneNumbers) {
            addRecord(name, s);
        }
        return map.get(name);
    }

    ArrayList<String> removeRecordByName(String name) throws RecordNotPresentException{
        lookUp(name);
        return map.remove(name);
    }

    boolean removePhoneNumber(String phoneNumber) throws RecordNotPresentException {
        String name = reverseLookUp(phoneNumber);
        return name != null && map.get(name).remove(phoneNumber);
    }

    String allNamesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    String allEntriesToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        for(Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
            sb.append(entry.getKey() + ": " + entry.getValue() + "\n");
        }
        return sb.toString();
    }

    String reverseLookUp(String number) throws RecordNotPresentException {
        for(String s : map.keySet()) {
            if(map.get(s).contains(number)) {
                return s;
            }
        }
        throw new RecordNotPresentException();
    }

}
