package reynoldsgillian.titko;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class PhoneBook extends TreeMap<String, ArrayList> { //modify to take an array of phone numbers

    /* Part 3: Refactor your PhoneBook class to map names to lists of phone
    numbers. You should modify your add() and remove() methods to handle adding or removing individual numbers,
    and create a removeRecord method for removing an entire entry from your PhoneBook.*/

    public String lookup(String name) {

        return this.get(name).toString(); //modify to get the array value as a string
    }

    public void add(String name, String number) {

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

    public String reverseLookup(String number) {
        String nameToReturn = "test";
        for (Object key : this.keySet()) {
            for (Object value : this.get(key)) {
                if (number.equals(value)) { //get the phone number at the key location in the array
                    nameToReturn = (String) key;
                }
            }
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
