package mattern.william;

import java.util.TreeMap;

/**
 * Created by williammattern on 2/7/17.
 */
public class PhoneBook {
    TreeMap<String,String> phoneBook = new TreeMap<String, String>();

    public void addEntry(String name, String phoneNumber){
        phoneBook.put(name, phoneNumber);

    }

    public void deleteEntry(String name){
        phoneBook.remove(name);

    }

    public String lookup(String name){
        return phoneBook.get(name);
    }

    public String getAllNames(){
        return phoneBook.entrySet().toString();
    }

}
