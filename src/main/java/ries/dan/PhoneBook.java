package ries.dan;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by danries on 2/7/17.
 */
public class PhoneBook extends TreeMap<String,ArrayList> {

    public String lookUp(String name){
        return this.get(name).toString();
    }

    public void addEntry(String name, String number){

        if (this.get(name) == null || this.get(name).equals(0)){
            ArrayList<String> numbers = new ArrayList<String>();
            numbers.add(number);
            this.put(name,numbers);
        }
        else if (this.containsKey(name)){
                this.get(name).add(number);
            }
    }

    public void removeNumber(String name, String number){

        ArrayList<String> temp = new ArrayList<String>();

        for (Object key : this.keySet()){
            if (name.equals(key)){
                temp = this.get(name);
                for (String digits : temp){
                    if (digits.equals(number)){
                        temp.remove(digits);
                    }
                }
            }
        }
        this.put(name,temp);
    }

    public void listAllNames(){
        System.out.println(this.keySet());
    }

    public void listAllEntries(){
        for (Object key : this.keySet()){
            System.out.println(key + " " + this.get(key));
        }
    }

    public String reverseLookUp(String number){
        String name = "";
        number = "[" + number + "]";
        for (Object key : this.keySet()){
            if (number.equals(this.get(key).toString())){
                name = key.toString();
            }
        }
        return name;
    }

    //public changeNumberstoString
}
