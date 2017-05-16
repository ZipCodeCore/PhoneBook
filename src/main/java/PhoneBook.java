import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class PhoneBook {

    public String name;
    public String phoneNumber;
    public String formattedPhoneNumber;
    public boolean isNamePresent;

    TreeMap<String, String> phoneBook = new TreeMap<String, String>();

    public void addPhoneBookEntry(String phoneNumber, String name){
        this.phoneNumber = phoneNumber;
        this.name = name;
        phoneBook.put(phoneNumber, name);
    }

    public void removePhoneBookEntryByPhoneNumber(String phoneNumber){
        phoneBook.remove(phoneNumber);
    }
    public void removePhoneBookEntryByName(String name){
        phoneBook.remove(name);
    }
    public void listAllEntriesInPhoneBook(){
        Set set = phoneBook.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println("Name: " + entry.getValue() + "\tNumber : " + entry.getKey() );
        }
    }
    public void lookUpPhoneNumberBasedOnName(String phoneNumber) {
        phoneBook.get(phoneNumber);
    }






}
