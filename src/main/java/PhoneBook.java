import java.util.Collection;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by cameronsima on 5/16/17.
 */
public class PhoneBook {

    private TreeMap<String, String> entries = new TreeMap<>();

    public String lookup(String name) {
        return entries.get(name);
    }

    public void add(String name, String phoneNumber) {
        entries.put(name, phoneNumber);
    }

    public void remove(String name) {
        entries.remove(name);
    }

    public TreeMap<String, String> listAllEntries() {
        return entries;
    }
    public Collection<String> listAllNames() {
        return entries.values();
    }

}
