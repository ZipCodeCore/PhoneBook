package ibikunle.tolani;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class PhoneBook extends TreeMap {

    public String lookUp(String name) {

        return (String) this.get(name);
    }

    public void add(String name, String phoneNumber) {
        this.put(name, phoneNumber);
    }

    public void removeEntry(String name) {
        this.remove(name);


    }

    public void listAllNames() {

        for (Object key : this.keySet()) { // this is printing all of the keys essentially the list names in the keySet
            System.out.println(key);
        }

    }

    public void listAllEntries() {
        for (Object key : this.keySet()) {
            System.out.println(key + " " + this.get(key)); // this prints the key and values . this. get key prints all the values.
        }
    }
}