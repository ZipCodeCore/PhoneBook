import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by andrewwong on 5/16/17.
 */
public class PhoneBook {

    private Map<String, ArrayList<PhoneNumber>> contacts = new TreeMap<String, ArrayList<PhoneNumber>>();

    public Map<String, ArrayList<PhoneNumber>> getContacts() {
        return contacts;
    }

    public void add(String name, PhoneNumber phoneNumber) {
        ArrayList<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumbers.add(phoneNumber);
        contacts.put(name, phoneNumbers);
    }

    public void addToExisting(String name, PhoneNumber phoneNumber) {
        ArrayList<PhoneNumber> contactsPhoneNumbers = contacts.get(name);
        contactsPhoneNumbers.add(phoneNumber);
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public void removeFromExisting(String name, PhoneNumber phoneNumber2) {
        contacts.get(name).remove(phoneNumber2);
    }

    public String listAllNames() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ArrayList<PhoneNumber>> entry : contacts.entrySet()) {
            sb.append(entry.getKey() + "\n");
        }
        return sb.toString();
    }

    public String listAllEntries() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, ArrayList<PhoneNumber>> entry : contacts.entrySet()) {
            sb.append(entry.getKey() + " - " + entry.getValue().get(0).toString());

            for(int i = 1; i < entry.getValue().size(); i++){
                sb.append(", " + entry.getValue().get(i).toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //TODO have throw a UnableToFindAssociatedPhoneNumberException;
    public ArrayList<PhoneNumber> lookup(String name){
        return contacts.get(name);
    }

    //TODO have throw a UnableToFindAssociatedNameException;
    public String reverseLookup(PhoneNumber phoneNumber){
        String name = "";
        for (Map.Entry<String, ArrayList<PhoneNumber>> entry : contacts.entrySet()) {
            for(int i = 0; i < entry.getValue().size(); i++){
                if(entry.getValue().get(i).equals(phoneNumber)) name = entry.getKey();
            }
        }
        return name;
    }



    //TODO if want to do logging, make sure i have log4j properties in resources folder
}
