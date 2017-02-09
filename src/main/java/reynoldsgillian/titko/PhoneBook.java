package reynoldsgillian.titko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class PhoneBook extends TreeMap<String, ArrayList> { //modify to take an array of phone numbers

    /*Exceptions: Update your Phonebook from parts 1-3. Any methods that accept a phone number should throw an
    InvalidPhoneNumberFormat exception if an invalid phone number format is used. At a minimum you must
    support phone numbers in (###) ###-#### format; you may choose to support other formats but they must be
    documented. No method should add an invalid phone number to your phonebook. If either lookup method or the
    remove method is called with an argument that does not exist in the phonebook (either a phone number or a
    contact) then a RecordNotPresent exception should be thrown. There may be some methods that could throw more
    than one type of exception. Your tests should account for the possibility of exceptions and test for those
    exceptions that are expected..*/

    public String lookup(String name) {

        return this.get(name).toString(); //modify to get the array value as a string
    }

    public void add(String name, String number) throws InvalidNumberFormatException {
        try{
            if(!number.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
                throw new InvalidNumberFormatException();
            }
            //Check if name is in the phone book first as well as check if the array size is not zero
            //If the name is already in the book, add the new number to the key that is already there
            if (this.get(name) != null) {
                this.get(name).add(number);
            } else {
                //otherwise create a new array of numbers
                ArrayList<String> numbers = new ArrayList();
                numbers.add(number); //add the number to the array of phone numbers (for the given name)
                this.put(name, numbers);
            }
        } catch (InvalidNumberFormatException e){
            System.out.println("Invalid phone number format");
        }
    }

    //We already have remove with the Treemap so rename our remove method
    public void removeEntry(String entryName) { //removes entire entry from phonebook

        this.remove(entryName);
    }

    public void listAllNames() { //get the names (keys)
        for (Object key : this.keySet())
            System.out.println(key);
    }

    public void listAllEntries() { //get the names(keys) and numbers(values)
        for (Object key : this.keySet())
            System.out.println(key + " " + this.get(key));
    }

    public String reverseLookup(String number) throws InvalidNumberFormatException {
        String nameToReturn = "";
        try{
            if(!number.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
                throw new InvalidNumberFormatException();
            }

            for (Object key : this.keySet()) {
                for (Object value : this.get(key)) {
                    if (number.equals(value)) { //get the phone number at the key location in the array
                        nameToReturn = (String) key;
                    }
                }
            }

        } catch (InvalidNumberFormatException e) {
                System.out.println("Invalid phone number format");
            }
        return nameToReturn;
        }


    public void removeSingleNumber(String number) {
        for (Object key : this.keySet()) {
            //need to use iterator since we'll get concurrent error if we loop over the keys & try to remove
            // them at the same time
            Iterator iter = this.get(key).iterator(); //create an iterator for the arraylist
            while(iter.hasNext()){
                if (iter.next().equals(number)) { //see if the value the iterator has equals the number of interest
                    iter.remove();
                }
            }
        }
    }
}
