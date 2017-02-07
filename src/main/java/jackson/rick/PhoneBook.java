package jackson.rick;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rickjackson on 2/7/17.
 */
public class PhoneBook {
    Map<String, List<String>> phoneNumbers;
    
    public PhoneBook() {
        this.phoneNumbers = new TreeMap<>();
        
    }
    
    public String lookup(String name) {
        return this.phoneNumbers.get(name).toString();
    }
    
    public String reverseLookup(String phoneNumber) {
        for (String k : this.phoneNumbers.keySet()) {
            if (this.phoneNumbers.get(k).contains(phoneNumber)) {
                return k;
            }
        }
        return null;
    }
    
    public void add(String name, String phoneNumber) {
        if (this.phoneNumbers.containsKey(name)) {
            this.phoneNumbers.get(name).add(phoneNumber);
        } else {
            this.phoneNumbers.put(name, new ArrayList<>());
            this.phoneNumbers.get(name).add(phoneNumber);
        }
    }
    
    public void remove(String name, String phoneNumber) {
        this.phoneNumbers.get(name).remove(phoneNumber);
    }
    
    public void removeRecord(String name) {
        this.phoneNumbers.remove(name);
    }
    
    public void listAllNames() {
        System.out.println(this.phoneNumbers.keySet().toString());
    }
    
    public void listAllEntries() {
        System.out.println(this.phoneNumbers.entrySet().toString());
    }
}