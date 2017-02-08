import java.util.*;

/**
 * Created by ryangross on 2/7/17.
 */
public class PhoneBook extends TreeMap {

    private Map<String, List<String>> ph = new TreeMap<String, List<String>>();


    public Map<String, List<String>> getPh() {
        return ph;
    }


    // modify all to take multiple Strings.
    public void add(String aName, String aNumber) throws InvalidPhoneNumberException {



        if (aNumber.length() == 14) {
            if (!ph.containsKey(aName)) {
                ArrayList<String> numbers = new ArrayList<String>();
                numbers.add(aNumber);
                ph.put(aName, numbers);
            } else {
                ph.get(aName).add(aNumber);
            }
        } else {
            System.out.println("Invalid number format");
            throw new InvalidPhoneNumberException(aNumber);
        }
    }

    public String lookUp(String aName) {
        if (ph.containsKey(aName)) {
            String allNumbers = "";
            for (String singleNumber : ph.get(aName)) {
                allNumbers += singleNumber;
            }
            return allNumbers;
        } else {
            return "Not found.";
        }
    }

    public void remove(String aName) {
        if (ph.containsKey(aName)) {
            ph.remove(aName);
        }
    }


    public void removeSingleNumber(String aNumber) {
        for (String key : ph.keySet()) {
            for (String number : ph.get(key)) {
                if (number.equals(aNumber)) ;
                ph.get(key).remove(aNumber);
            }
        }
    }

    public void listAllNames() {
        for (String key : ph.keySet()) {
            System.out.println(key);
        }
    }

    public void listAllEntries() {
        for (String key : ph.keySet()) {
            System.out.println(ph.get(key));
        }
    }

    public String reverseLookUp(String aNumber) {
        for (String key : ph.keySet()) {
            for (String number : ph.get(key)) {
                if (number.equals(aNumber)) {
                    return key;
                }
            }
        }
        return "Not found";
    }
}





