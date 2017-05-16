import java.util.TreeMap;

/**
 * Created by sarahweisser on 5/16/17.
 */
public class PhoneBook {

    private TreeMap phoneBook = new TreeMap();

    public TreeMap getPhoneBook() {
        return phoneBook;
    }

    public Object lookup(String name) {
        return phoneBook.get(name);
    }

    public void addEntry(PhoneBookEntry entry) {
        phoneBook.put(entry.getName(), entry.getFormattedPhoneNumber());
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

}
