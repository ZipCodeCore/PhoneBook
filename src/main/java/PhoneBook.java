import java.util.*;

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
        phoneBook.put(entry.getName(), entry.getFormattedPhoneNumbers().toString());
    }

    public String addNumberToEntry(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {
        PhoneBookEntry entry = new PhoneBookEntry(name);
        entry.addNumber(lookup(name));
        entry.addNumber(phoneNumber);
        addEntry(entry);
        return lookup(name);
    }

    public String removeEntry(String name) {
        return phoneBook.remove(name);
    }

    public String[] showEntries() {
        String[] listings = new String[phoneBook.size()];
        Set<String> keys = phoneBook.keySet();
        int i = 0;
        for(String key : keys) {
            listings[i] = "Name: " + key + "; Phone Number(s): " + lookup(key);
            i++;
        }
        return listings;
    }

    public String reverseLookup(String phoneNumber) {
        String[] listings = new String[phoneBook.size()];
        Set<String> keys = phoneBook.keySet();
        int i = 0;
        for(String key : keys) {
            if (lookup(key).contains(phoneNumber)) {
                return key;
            }
        }
        return null;
    }

    public void removeNumberFromEntry(String key, String phoneNumber) throws InvalidPhoneNumberFormatException {
        PhoneBookEntry entry = new PhoneBookEntry(key);
        String [] numbers = lookup(key).split(", ");
        ArrayList<String> editedNumbers = new ArrayList<String>(Arrays.asList(numbers));
        editedNumbers.remove(phoneNumber);
        for (String number : editedNumbers) {
            entry.addNumber(number);
        }
        phoneBook.put(entry.getName(), entry.getFormattedPhoneNumbers().toString());
    }
}
