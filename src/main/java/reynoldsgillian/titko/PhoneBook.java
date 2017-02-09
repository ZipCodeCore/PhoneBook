package reynoldsgillian.titko;

import java.util.TreeMap;

/**
 * Created by gillianreynolds-titko on 2/7/17.
 */
public class PhoneBook extends TreeMap {

    /*Part 1: Create a PhoneBook class that holds names and phone numbers in sorted order. You can use an associative data
    type (one which stores items as keys paired with values). Your PhoneBook class should have a lookup() method
    which allows you to look up a person's phone number based on their name. PhoneBook should also have methods to
    add and remove entries, or to list all names or all entries (names and phone numbers).*/

    public String lookup(String name){
        return (String) this.get(name);
    }

    public void add(String name, String number){
        this.put(name, number);
    }

    //We already have remove with the Treemap
    public void removeEntry(String entryName){
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

}
