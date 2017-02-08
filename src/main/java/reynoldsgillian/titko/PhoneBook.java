package reynoldsgillian.titko;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class PhoneBook extends TreeMap<String, ArrayList> { //modify to take an array of phone numbers

    /*Part 1: Create a PhoneBook class that holds names and phone numbers in sorted order. You can use an associative data
    type (one which stores items as keys paired with values). Your PhoneBook class should have a lookup() method
    which allows you to look up a person's phone number based on their name. PhoneBook should also have methods to
    add and remove entries, or to list all names or all entries (names and phone numbers).*/

    public String lookup(String name){
        return this.get(name).toString(); //modify to get the array value as a string
    }

    public void add(String name, String number) {

        //Check if name is in the phone book first as well as check if the array size is not zero
        //If the name is already in the book, add the new number to the key that is already there
        if (this.get(name) != null || this.get(name).size() != 0) {
            this.get(name).add(number);
        } else {

            //otherwise create a new array of numbers
            ArrayList<String> numbers = new ArrayList();
            numbers.add(number); //add the number to the array of phone numbers (for the given name)
            this.put(name, numbers);
        }
    }

    //We already have remove with the Treemap so rename our remove method
    public void removeEntry(String entryName){ //removes entire entry from phonebook
        this.remove(entryName);
    }

    public void listAllNames(){ //get the names (keys)
        for(Object key: this.keySet())
        System.out.println(key);
    }

    public void listAllEntries(){ //get the names(keys) and numbers(values)
        for(Object key: this.keySet())
            System.out.println(key + " " + this.get(key));
    }

    public String reverseLookup(String number){
        String nameToReturn = "";
        for(Object key: this.keySet()){
            if(number.equals(this.get(key))){
                nameToReturn = (String) key;
            }
        }
        return nameToReturn;
    }

    public void removeSingleNumber(String name, String entryNumber){ //for a given number, remove single number from phonebook

        ArrayList<String> temp = new ArrayList<>();
       for(Object key: this.keySet()){
           if(key.equals(name)){
               temp = this.get(name);
               for(Object value: this.get(name)){
                   if(value == entryNumber){
                       temp = this.get(name);
                       temp.remove(value);
                   }
               }
           }
       } this.put(name, temp);
    }
}
