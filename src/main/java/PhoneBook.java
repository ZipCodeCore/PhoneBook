import java.util.HashMap;
import java.util.Map;

/**
 * Created by cameronsima on 5/16/17.
 */
public class PhoneBook {

    private HashMap<String, String> entries = new HashMap<>();

    public String lookup() {
        return "Hi";
    }
    public void add(String name, String phoneNumber) {
        entries.put(name, phoneNumber);

    }
    public String[] listAllEntries() {
 /*       String[] result = new String[entries.size()];

        entries.forEach((name, phoneNumber) -> {
            result.add(String.format("%s, %s", name, phoneNumber);
        });*/

        return entries.keySet().toArray(new String[entries.size()]);


    }
    public String[] listAllNames() {
        return new String[1];
    }

}
