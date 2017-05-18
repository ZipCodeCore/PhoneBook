package zygmundfelt.dan.holdingobjects;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class PhoneBook {

    Map<String,ArrayList<String>> map;
    private static final Logger logger = Logger.getLogger("zygmundfelt.dan.holdingobjects");

    PhoneBook() {
        map = new TreeMap<String,ArrayList<String>>();
    }

    private String validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        if (phoneNumber.matches("\\(\\d{3}\\) \\d{3}-\\d{4}$")) {
            if(phoneNumber.charAt(1) == '0'){
                throw new InvalidPhoneNumberFormatException();
            }
            return phoneNumber;
        }
        return attemptToConvertFromNumericalFormat(phoneNumber);
    }

    private String attemptToConvertFromNumericalFormat(String phoneNumber) throws InvalidPhoneNumberFormatException {
        try {
            Long.parseLong(phoneNumber);
            if(phoneNumber.charAt(0) == '0' || phoneNumber.length() != 10) {
                throw new InvalidPhoneNumberFormatException();
            }
            return buildPhoneNumber(phoneNumber);
        } catch (Exception e) {
            throw new InvalidPhoneNumberFormatException();
        }
    }

    private String buildPhoneNumber(String phoneNumber) {
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

    /*
    Helper method for addRecord.
     */
    private ArrayList<String> createNewRecord(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {
        logger.info("Attempting to create record: " + name + ", " + phoneNumber);
        ArrayList<String> list = new ArrayList<String>();
        list.add(phoneNumber);
        return map.put(name, list);
    }

    /*
    Not sure if it'd be better to switch the blocks in if and else.
     */
    ArrayList<String> addRecord(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {
        try {
            String validPhoneNumber = validatePhoneNumber(phoneNumber);
            if(map.get(name) == null) {
                return createNewRecord(name, validPhoneNumber);
            } else {
                map.get(name).add(validPhoneNumber);
                return map.get(name);
            }
        } catch (InvalidPhoneNumberFormatException e) {
            logger.warning("Unable to create record of phone number " + phoneNumber + ": Invalid format.");
            throw new InvalidPhoneNumberFormatException();
        }
    }

    ArrayList<String> addRecords(String name, String... phoneNumbers) throws InvalidPhoneNumberFormatException {
        for(String s : phoneNumbers) {
            addRecord(name, s);
        }
        return map.get(name);
    }

    ArrayList<String> lookUp(String name) throws RecordNotPresentException{
        ArrayList<String> result = map.get(name);
        if(result == null) {
            logger.warning("Unable to find nonexistent record for " + name);
            throw new RecordNotPresentException();
        }
        return result;
    }

    String reverseLookUp(String number) throws RecordNotPresentException {
        for(String s : map.keySet()) {
            if(map.get(s).contains(number)) {
                return s;
            }
        }
        logger.warning("Unable to locate nonexistent phone number: " + number);
        throw new RecordNotPresentException();
    }

    ArrayList<String> removeRecordByName(String name) throws RecordNotPresentException{
        lookUp(name);
        return map.remove(name);
    }

    boolean removePhoneNumber(String phoneNumber) throws RecordNotPresentException {
        String name = reverseLookUp(phoneNumber);
        return map.get(name).remove(phoneNumber);
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

}