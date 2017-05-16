import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by brianmullin on 5/16/17.
 */
public class PhoneBook {

    private String name;
    private String phoneNumber;

    public PhoneBook(){}

    public static TreeMap<String, String> phoneBook = new TreeMap<String, String>();

    public String lookUpByName(String name){

        String entry = phoneBook.get(name);
        return entry;
    }

    public String addEntries(String name, String phoneNumber){

        phoneBook.put("", phoneNumber);

        return "The entry" + phoneBook.get(name) + "was added to phoneBook";

    }

    public void removeEntries(String name){

        phoneBook.remove(name);

    }

    public String listAllEntries(){



        return "";
    }

}
