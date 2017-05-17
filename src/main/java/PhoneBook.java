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

    public void removeContact(String name) throws RecordNotPresentException{
        if (contacts.get(name)==null) throw new RecordNotPresentException();
        contacts.remove(name);
    }

    public void removeFromExisting(String name, PhoneNumber phoneNumber2) throws RecordNotPresentException {
        if(!contacts.get(name).contains(phoneNumber2)) throw new RecordNotPresentException();
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

    public ArrayList<PhoneNumber> lookup(String name) throws RecordNotPresentException {
        if(contacts.get(name)==null) throw new RecordNotPresentException();

        return contacts.get(name);

    }

    public String reverseLookup(PhoneNumber phoneNumber) throws RecordNotPresentException{
        String name = null;
        for (Map.Entry<String, ArrayList<PhoneNumber>> entry : contacts.entrySet()) {
            for(int i = 0; i < entry.getValue().size(); i++){
                if(entry.getValue().get(i).equals(phoneNumber)) name = entry.getKey();
            }
        }
        if(name==null) {
            throw new RecordNotPresentException();
        }
        return name;
    }
}
