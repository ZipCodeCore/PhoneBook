import java.util.TreeMap;

/**
 * Created by brianmullin on 5/16/17.
 */
public class PhoneBook {

    private String name;
    private String phoneNumber;

    public PhoneBook(){}

    public static TreeMap<String, String> phoneBook = new TreeMap<String, String>();

    public String lookUpByName(String name){

        String entry= phoneBook.get(name);
        return entry;
    }

    public void addEntries(String name, String phoneNumber){

        phoneBook.put(name, phoneNumber);
    }

    public void removeEntries(){}

    public String listAllEntries(){

        return "";
    }

}
