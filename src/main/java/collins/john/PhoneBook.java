package collins.john;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by johncollins on 2/7/17.
 */
public class PhoneBook {
    Map<String, Entries> phoneBook;
    String k;

    public PhoneBook() {
        phoneBook = new TreeMap<String, Entries>() {
        };
    }

    public void addEntry(String name, String number) {
        Entries contactNumbers = new Entries(number);
        phoneBook.put(name, contactNumbers);
    }

    public void removeEntry(String name) {
        phoneBook.remove(name);
    }

    public String lookup(String name) {
        String numbers = phoneBook.get(name).phoneNumbers.toString();
        return numbers;
    }

    public void printEntriesKeys() {
        System.out.println(phoneBook.keySet());

    }

    public String printEntries() {
        Set keys = phoneBook.keySet();
        for (Object key : keys
                ) {
            return key + "    " + phoneBook.get(key).getNumbers();// cite: http://www.java2novice.com/java-collections-and-util/treemap/iterate/
        }
        return "Phonebook is empty";
    }

    public String reverseLookup(String searchNumber) {
        Set keys = phoneBook.keySet();
        String targetKey = "Does not exist";
        for (Object key : keys
                ) {
            for (int i = 0; i < phoneBook.get(key).phoneNumbers.size(); i++) {
                if (searchNumber.equals(phoneBook.get(key).phoneNumbers.get(i).toString())) {
                    targetKey = key.toString();
                }
            }
        }
        return targetKey;
    }


}
