import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by eugenevendensky on 2/7/17.
 */
public class PhoneBook {

    public TreeMap<String, Entry> entries = new TreeMap<String, Entry>();

    public void addEntries(String name, String number) {
        if (entries.containsKey(name)) {
            Entry temp = entries.get(name);
            temp.addPhoneNumber(number);
        } else {
            Entry entry = new Entry(number);
            entries.put(name, entry);
        }

    }

    public String lookUp(String name) {
        Entry temp = entries.get(name);
        String numbers = temp.getNumbers();
        return numbers;
    }

    public String reverseLookUp(String number) {

        Set set = entries.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {

            Map.Entry me = (Map.Entry) i.next();
            Entry meNumber = (Entry) me.getValue();

            if (meNumber.getNumbers().contains(number)) {

                String nameFound = (String) me.getKey();
                return nameFound;

            }

        }
        String noRecord = "There is no record of that number in the phone-book";
        return noRecord;
    } // this method to be refactored with a for-each

    public void printEntries() {
        Set set = entries.entrySet();
        Iterator i = set.iterator();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            Entry entry = (Entry) me.getValue();
            System.out.println("Name : " + me.getKey() + " Numbers : " + entry.getNumbers());
        }


    }
}


