import java.util.Map;
import java.util.TreeMap;

/**
 * Created by vidyachandasekhar on 5/16/17.
 */
public class PhoneBook {


    private Map<String, String> phoneMap = new TreeMap();


    public void addEntry(String name, String number) {
        phoneMap.put(name, number);

    }

    public void deleteEntry(String name) {
        phoneMap.remove(name);

    }

    public String lookUpName(String name) {
        return phoneMap.get(name);
    }

    public String lookUpAllEntries() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : phoneMap.entrySet()) {
            stringBuilder.append(("Name : " + entry.getKey() + " Phone Number : " + entry.getValue() + "\n"));
        }
        return stringBuilder.toString();
    }


}
