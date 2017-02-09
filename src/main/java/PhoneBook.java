import java.util.*;

/**
 * Created by ryangross on 2/7/17.
 */
public class PhoneBook extends TreeMap {

    private Map<String, List<String>> ph = new TreeMap<>();


    public Map<String, List<String>> getPh() {
        return ph;
    }


    // modify all to take multiple Strings.
    public void add(String aName, String aNumber) throws InvalidPhoneNumberException {
        try {
            if (aNumber.length() == 14) {
                if (!ph.containsKey(aName)) {
                    ArrayList<String> numbers = new ArrayList<String>();
                    numbers.add(aNumber);
                    ph.put(aName, numbers);
                } else {
                    ph.get(aName).add(aNumber);
                }
            } else {
                throw new InvalidPhoneNumberException();
            }
        } catch(InvalidPhoneNumberException e) {
            System.out.println("Invalid number format");
        }
    }


    public String lookUp(String aName) throws RecordNotPresentException {

        try {
            if (ph.containsKey(aName)) {
                String allNumbers = "";
                for (String singleNumber : ph.get(aName)) {
                    allNumbers += singleNumber;
                }
                return allNumbers;
            } else {
                throw new RecordNotPresentException();
            }
        } catch (RecordNotPresentException e) {
            System.out.println("Record not found.");

        }
        return null;
    }


    public void remove(String aName) throws RecordNotPresentException {
        try {
            if (ph.containsKey(aName)) {
                ph.remove(aName);
            } else {
                throw new RecordNotPresentException();
            }
        } catch (RecordNotPresentException e) {
            System.out.println("Record not found.");
        }
    }


    public void removeSingleNumber(String aNumber) throws InvalidPhoneNumberException {
        try {
            if (aNumber.length() == 14) {
                for (String key : ph.keySet()) {
                    for (String number : ph.get(key)) {
                        if (number.equals(aNumber)) ;
                        ph.get(key).remove(aNumber);
                    }
                }
            } else {
                throw new InvalidPhoneNumberException();
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Invalid number format.");
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

    public String reverseLookUp(String aNumber) throws InvalidPhoneNumberException, RecordNotPresentException {

        try {
            if (aNumber.length() == 14) {
                if (doesExist(aNumber)) {
                    for (String key : ph.keySet()) {
                        for (String number : ph.get(key)) {
                            if (number.equals(aNumber)) {
                                return key;
                            }
                        }
                    }
                } else {
                    throw new RecordNotPresentException();
                }

            } else {
                throw new InvalidPhoneNumberException();
            }
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Invalid number");
        } catch (RecordNotPresentException e) {
            System.out.println("No record found.");
        }
        return null;
    }


    public boolean doesExist(String aNumber) {
        for (String key : ph.keySet()) {
            for (String number : ph.get(key)) {
                if (number.equals(aNumber)) {
                    return true;
                }
            }
        }
        return false;
    }



}





