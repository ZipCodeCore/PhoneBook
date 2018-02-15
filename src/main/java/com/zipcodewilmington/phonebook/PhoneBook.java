package com.zipcodewilmington.phonebook;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {
    private TreeMap<String, ArrayList> phoneBook;
    ArrayList<String> phoneNumberList;

    public PhoneBook(){
        this.phoneBook = new TreeMap<String, ArrayList>();
    }



    public void add(String name, String... phoneNumber){
        phoneNumberList = new ArrayList<String>();
        for (String number : phoneNumber){
            phoneNumberList.add(number);
        }
        phoneBook.put(name, phoneNumberList);
    }

    public String lookUp(String name){
        String result = String.valueOf(phoneBook.get(name));
        return result.substring(1, result.length()-1);
    }

    public String reverseLookup(String number) {
        String result = "";
        for (Map.Entry<String, ArrayList> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(number)) {
                result = entry.getKey();
            }
        }
;
        return result;
    }

    public String getPhoneBook(){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, ArrayList> entry : phoneBook.entrySet()){
            result.append(String.format("%-20s", entry.getKey()));
            for(int i = 0; i < entry.getValue().size(); i++){
                result.append(entry.getValue().get(i));
                result.append(" ");
            }
            result.append("\n");
//            result.append(String.format("%-20s %8s\n", entry.getKey(), arrayResultIn));
        }
        return result.toString();
    }

    public Boolean removeRecord(String name){
        Boolean result = true;
        phoneBook.remove(name);
        if (!(lookUp(name).equals(name))){
            result = false;
        }
        return result;
    }

    public Boolean removeEntry(String name, String number){
        Boolean result = true;
        phoneBook.get(name).remove(number);
        if (!(reverseLookup(number).equals(number))){
            result = false;
        }
        return result;
    }




}