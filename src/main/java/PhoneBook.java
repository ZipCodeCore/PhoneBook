import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by andrewwong on 5/16/17.
 */
public class PhoneBook {

    private Map<String, PhoneNumber> phoneNumbers = new TreeMap<String, PhoneNumber>();

    public Map<String, PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void add(String name, PhoneNumber phoneNumber) {
        phoneNumbers.put(name, phoneNumber);
    }

    public void remove(String name) {
        phoneNumbers.remove(name);
    }

    public String listAllNames() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, PhoneNumber> entry : phoneNumbers.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    public String listAllEntries() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, PhoneNumber> entry : phoneNumbers.entrySet()) {
            sb.append(entry.getKey() + " - " + entry.getValue().toString() + "\n");
        }
        return sb.toString();
    }

    public PhoneNumber lookup(String name){
        return phoneNumbers.get(name);
    }

}
