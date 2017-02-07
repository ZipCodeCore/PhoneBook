package ries.dan;

import java.util.TreeMap;

/**
 * Created by danries on 2/7/17.
 */
public class PhoneBook extends TreeMap {

    public String lookUp(String name){
        return this.get(name).toString();
    }

    public void addEntry(String name, String number){
        this.put(name,number);
    }

    public void removeEntry(String name){
        this.remove(name);
    }

    public void listAllNames(){
        System.out.println(this.keySet());
    }

    public void listAllEntries(){
        for (Object key : this.keySet()){
            System.out.println(key + " " + this.get(key));
        }
    }

    /*public String reverseLookUp(String number){
        return null;
    }*/

    //public changeNumberstoString
}
