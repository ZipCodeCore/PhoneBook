package Kim.Andy;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by andykim on 2/12/17.
 */
public class PhoneBook extends TreeMap {

    String name;

    String number;


    TreeMap<String, String> phonebook =  new TreeMap<String, String>();


    public String lookUp(String name){
        return phonebook.get(name);
    }

    public void add(String name, String number){
        phonebook.put(name, number);
    }

    public void remove(String name){
        phonebook.remove(name);
    }

    public void listAllNames(){
        Set<String> keys = phonebook.keySet();
        for (String key: keys){
            System.out.println(key);
        }
    }

    public void listAllEntries(){
        for (Object name: phonebook.keySet()){
            System.out.println(name + " " + phonebook.get(name));
        }

    }


}
