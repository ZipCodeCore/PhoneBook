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


//    public static void main(String[] args) {

     TreeMap<String, String> phoneBook = new TreeMap<String, String>();

    // private String nameEntry = "";

   //  private String numberEntry = "";

     private void addEntry(String nameEntry, String numberEntry){
        phoneBook.put(nameEntry, numberEntry);

    }

     private void removeEntry(String nameEntry){
        phoneBook.remove(nameEntry);

     }

     public String entryLookup(String nameEntry){
        return phoneBook.get(nameEntry);

     }

     public String entryListAll() {
        String fullList = "";
         Set<String> keys = phoneBook.keySet();
        for (String key: keys){
            fullList += key + " : " + phoneBook.get(key);

        }
        return fullList;
     }

    public static void main(String[] args) {
       PhoneBook nameNumber = new PhoneBook();
       nameNumber.addEntry("Albert", "111111111 \n");
       nameNumber.addEntry("Bobby", "222222222 \n");
       nameNumber.entryListAll();
       //nameNumber.removeEntry("Albert", "111111111");
      //  System.out.println(nameNumber.entryLookup("Albert"));
        System.out.println(nameNumber.entryListAll());

    }

}
