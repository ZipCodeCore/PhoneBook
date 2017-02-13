package Kim.Andy;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by andykim on 2/12/17.
 */
public class PhoneBook extends TreeMap <String, ArrayList> {

    String name;

    String number;



    public ArrayList<String> lookUp(String name) {
        return this.get(name);
    }



    public void listAllNames() {
        Set<String> keys = this.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
    }

    public void listAllEntries() {
        for (Object name : this.keySet()) {
            System.out.println(name + " " + this.get(name));
        }

    }

    public String reverseLookUp(String number) {//this function never enters my IF statement, always returns null. HELP
        String answer = number;
        for (Object key : this.keySet()) {
            if (this.get(key).equals(this.keySet())) {
                answer = (String) key;

            }

        }
        return answer;
    }

    public void add(String name, String number) {
        ArrayList<String> phoneNumbers = this.get(name);
        if (phoneNumbers == null){
            phoneNumbers = new ArrayList<String>();
            phoneNumbers.add(number);
            this.put(name, phoneNumbers);
        }
        else {
            phoneNumbers.add(number);
        }
    }



    public void removeASingleNumber(String number) {
        for (Object name : this.keySet()){//iterating through the names in the contact list.
            Iterator iterator = this.get(name).iterator();
            while(iterator.hasNext()){
                if (iterator.next().equals(number))
                iterator.remove();
            }
        }
    }
    public void removeRecord(String name) {
        for (Object key : this.keySet()){
            if (key.equals(name)){
                this.remove(name);
            }
        }
    }
}
