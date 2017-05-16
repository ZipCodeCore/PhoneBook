import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by anthonyjones on 5/16/17.
 */
public class PhoneBook {

    Map<String, String> phoneInfo = new HashMap<String, String>();
    Scanner in = new Scanner(System.in);

    public PhoneBook() {

    }

    //Originally going to be voided methods, I decided to return the entire hashmap after it's populated
    public Map addEntry(String name, String phoneNumber) {

        return phoneInfo;
    }

    //Originally going to be voided methods, I decided to return the entire hashmap after a entry is removed.
    public Map removeEntry(String name) {
       
        return phoneInfo;
    }

    public void listName(String name) {
    }

    public void listAllEntries() {
    }

    //unsure how to populate Hashmap so I created  signature that takes in one and uses the putAll method.
    public String lookUp(Map hashMap, String name) {
        phoneInfo.putAll(hashMap);
        return phoneInfo.get(name);
    }

    public String reverseLookUp(String number) {
        return "";
    }


}
