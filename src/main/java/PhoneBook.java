import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class PhoneBook {

    static TreeMap<String, String> PhoneBook = new TreeMap<String, String>();

    public static void addPhoneBookEntry(String phoneNumber, String name){
        PhoneBook.put(phoneNumber, name);
    }

    public static void removePhoneBookEntryByPhoneNumber(String phoneNumber){
        System.out.println(PhoneBook.remove(phoneNumber));
    }

    public static void removePhoneBookEntryByName(String name){
        System.out.println("Deleting Entry : " + PhoneBook.remove(name));
    }

    public static void listAllEntriesInPhoneBook(){
        Set set = PhoneBook.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("Name: " + entry.getValue() + "\tNumber : " + entry.getKey() );
        }
    }
    public static void lookUpPhoneNumberBasedOnName(String name) {
        System.out.println("Number assosciated with Name : " + PhoneBook.get(name));
    }

    public static void lookUpNameBasedOnPhoneNuber(String phoneNumber) {
        System.out.println("Name assosciated with Number : " + PhoneBook.get(phoneNumber));
    }






}
