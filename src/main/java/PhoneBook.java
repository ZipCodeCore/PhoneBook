import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by brianmullin on 5/16/17.
 */
public class PhoneBook {

    //private String name;
    //private String phoneNumber;
    public static Map<String, String> phoneBook = new TreeMap<String, String>();

    public PhoneBook(){}


    public String lookUpByName(String name){

        String entry = phoneBook.get(name);
        return entry;
    }


    public String addEntries(String name, String phoneNumber){
        phoneBook.put(name, phoneNumber);

        return "The entry associated with " + phoneBook.get(name) + " was added to phoneBook";
    }


    public String removeEntries(String name){

        String number = phoneBook.get(name);
        phoneBook.remove(name);

        return "The entry '" + name + " " + number + "' was removed from phoneBook." +
                "It is now "+ phoneBook.get(name) + ".";
    }


    public String listAllEntries(){

        return "The full phoneBook list is: " + phoneBook.entrySet();
    }


    public String reverseLookUp(String phoneNumber){
        String name = "";
        for(Map.Entry<String, String> entry : phoneBook.entrySet()){
            if(entry.getValue().equals(phoneNumber))
                name += entry.getKey();
            //break;

        }
        return name;
    }

}
