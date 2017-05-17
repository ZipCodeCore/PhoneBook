import java.util.Set;
import java.util.TreeMap;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBook {

    private TreeMap<String, String> phoneBook = new TreeMap();

    public TreeMap getPhoneBook() {
        return phoneBook;
    }

    public String lookup(String name) {
        return phoneBook.get(name);
    }

    public void addEntry(PhoneBookEntry entry) {
        phoneBook.put(entry.getName(), entry.getFormattedPhoneNumber());
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

    public String[] showEntries() {
        String[] listings = new String[phoneBook.size()];
        Set<String> keys = phoneBook.keySet();
        int i = 0;
        for(String key : keys) {
            listings[i] = "Name: " + key + "; Phone Number: " + lookup(key);
            i++;
        }
        return listings;
    }

}
