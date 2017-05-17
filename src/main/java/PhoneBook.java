import java.util.*;

/**
 * Created by cameronsima on 5/16/17.
 */
public class PhoneBook {

    private TreeMap<String, ArrayList<String>> entries = new TreeMap<>();

    public ArrayList<String> lookup(String name) {
        return entries.get(name);
    }

    public String reverseLookup(String phoneNumber) {
        for (Map.Entry<String, ArrayList<String>> entry : entries.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void remove(String name, String phoneNumber) {
        ArrayList<String> numbers = lookup(name);
        numbers.remove(phoneNumber);

    }

    public void add(String name, String number) {

        if (entries.get(name) != null) {
            ArrayList<String> numbers = lookup(name);
            numbers.add(number);
        } else {
            ArrayList<String> phoneArr = new ArrayList<>();
            phoneArr.add(number);
            entries.put(name, phoneArr);
        }


    }

    public void removeEntry(String name) {
        entries.remove(name);

    }

    public TreeMap<String, ArrayList<String>> listAllEntries() {
        return entries;
    }
    public Collection<String> listAllNames() {
        return entries.keySet();
    }

}
