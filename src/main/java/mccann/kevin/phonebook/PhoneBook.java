package mccann.kevin.phonebook;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;

/**
 * Created by kevinmccann on 2/7/17.
 */
public class PhoneBook {

    TreeMap<String, ArrayList<String>> addressBook = new TreeMap<>();

    String lookup(String name) throws RecordNotPresentException {
        try {
            if(addressBook.get(name)==null)
                throw new RecordNotPresentException();
            return addressBook.get(name).toString();
        } catch (RecordNotPresentException e) {
            return "Name not in address book!";
        }
    }

    String reverseLookup(String phoneNumber) throws InvalidPhoneNumberException, RecordNotPresentException{
        try {
            if(!phoneNumber.matches("\\({3}\\)[-.\\s]{3}[-.\\s]{4}"))
                throw new InvalidPhoneNumberException();
            for (String name : addressBook.keySet()) {
                if (addressBook.get(name).contains(phoneNumber))
                    return name;
            }
            throw new RecordNotPresentException();
        } catch (InvalidPhoneNumberException e) {
            return "Invalid phone number!";
        } catch (RecordNotPresentException e) {
            return "Phone number not in address book!";
        }
    }

    void add(String name, String phoneNumber) throws InvalidPhoneNumberException {
        try {
            if (!phoneNumber.matches("\\({3}\\)[-.\\s]{3}[-.\\s]{4}"))
                throw new InvalidPhoneNumberException();
            if (addressBook.get(name) != null)
                addressBook.get(name).add(phoneNumber);
            else {
                ArrayList<String> numbers = new ArrayList<>();
                numbers.add(phoneNumber);
                addressBook.put(name, numbers);
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Invalid phone number!");
        }
    }

    void remove(String name, String phoneNumber) throws RecordNotPresentException, InvalidPhoneNumberException{
        try {
            if (!phoneNumber.matches("\\({3}\\)[-.\\s]{3}[-.\\s]{4}"))
                throw new InvalidPhoneNumberException();
            if (addressBook.get(name) == null)
                throw new RecordNotPresentException();
            addressBook.get(name).remove(phoneNumber);
        } catch (RecordNotPresentException e) {
            System.out.println("No entry for " + name + " in address book!");
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Invalid phone number!");
        }
    }

    void removeEntry(String name) throws RecordNotPresentException{
        try {
            if (addressBook.get(name) == null)
                throw new RecordNotPresentException();
            addressBook.remove(name);
        } catch (RecordNotPresentException e) {
            System.out.println("No entry for " + name + " in address book!");
        }
    }

    Collection listAllNames() {
        return addressBook.keySet();
    }

    Collection listAllEntries() {
        return addressBook.entrySet();
        }

    private class RecordNotPresentException extends Exception {
    }

    private class InvalidPhoneNumberException extends Exception {
    }
}
