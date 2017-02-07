package jackson.rick;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by rickjackson on 2/7/17.
 */
public class PhoneBook {
    Map<String, String> phoneNumbers;
    
    public PhoneBook() {
        this.phoneNumbers = new TreeMap<>();
        
    }
    
    public String lookup(String name) {
        return this.phoneNumbers.get(name);
    }
    
    public String reverseLookup(String name) {
        for (String k : this.phoneNumbers.keySet()) {
            if (this.phoneNumbers.get(k).equals(name)) {
                return k;
            }
        }
        return null;
    }
    
    public void add(String name, String phoneNumber) {
        this.phoneNumbers.put(name, phoneNumber);
    }
    
    public void remove(String name) {
        this.phoneNumbers.remove(name);
    }
    
    public void listAllNames() {
        System.out.println(this.phoneNumbers.keySet().toString());
    }
    
    public void listAllEntries() {
        System.out.println(this.phoneNumbers.entrySet().toString());
    }
}