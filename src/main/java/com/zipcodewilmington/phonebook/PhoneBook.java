package com.zipcodewilmington.phonebook;

import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.List;
/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {



     TreeMap<String, String> phoneBook = new TreeMap<String, String>();

     public void addEntry(String nameEntry, String numberEntry){
        phoneBook.put(nameEntry, numberEntry);

    }

     public void removeEntry(String nameEntry , String numberEntry){
        phoneBook.remove(nameEntry, numberEntry);


     }

     public String entryLookup(String nameEntry){
        return phoneBook.get(nameEntry);

     }

    public String entryListNames() {
        String fullListNames = "";
        Set<String> keys = phoneBook.keySet();
        for (String key: keys){
            fullListNames += key + "\n";

        }
        return fullListNames;
    }

    public String entryListNumbers() {
        String fullListNumbers = "";
        Set<String> keys = phoneBook.keySet();
        for (String key: keys){
            fullListNumbers += phoneBook.get(key) + "\n";

        }
        return fullListNumbers;
    }

     public String entryListAll() {
        String fullListAll = "";
         Set<String> keys = phoneBook.keySet();
        for (String key: keys){
            fullListAll += key + " : " + phoneBook.get(key);

        }
        return fullListAll;
     }

     public String reverseLookup(String numberEntry){
         String getKeyfromValue = "";
         Set<String> keys = phoneBook.keySet();
         for (String key: keys){
             if (phoneBook.get(key).equals(numberEntry)){
                 getKeyfromValue += key;
             }
         }
         return getKeyfromValue;
     }
    public static void main(String[] args) {
       PhoneBook nameNumber = new PhoneBook();
       nameNumber.addEntry("Albert", "111111111");
       nameNumber.addEntry("Bobby", "222222222");
       nameNumber.entryListAll();
       //nameNumber.removeEntry("Albert", "111111111");
      //  System.out.println(nameNumber.entryLookup("Albert"));
      //  System.out.println(nameNumber.entryListAll());
        System.out.println(nameNumber.reverseLookup("111111111"));
    }

}
