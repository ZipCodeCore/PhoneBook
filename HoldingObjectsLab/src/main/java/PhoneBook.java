import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by eugenevendensky on 2/7/17.
 */
public class PhoneBook {


    HashMap<String, String> phoneBook = new HashMap<String, String>();

    public void addAContact(String name, String number){
        Contact contact = new Contact(name, number);
        phoneBook.put(contact.name, contact.number);
    }

    public void removeAContact(String name){
        phoneBook.remove(name);
    }

    public void printAllNumbersAndContacts(){
        Set set = phoneBook.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            System.out.println("Name : " + me.getKey() + " Number : " + me.getValue());
        }

    }

    public String lookUp(String name) {
        Set set = phoneBook.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {

            Map.Entry me = (Map.Entry) i.next();
            String meKey = (String) me.getKey();
            if (meKey.equalsIgnoreCase(name)) {

                String phoneNumber = (String) me.getValue();
                return phoneNumber;

            }

        }
        String noRecord = "There is no record of that name in the phone-book";
        return noRecord;
    }

    public String reverseLookUp(String number){

        Set set = phoneBook.entrySet();
        Iterator i = set.iterator();

        while (i.hasNext()) {

            Map.Entry me = (Map.Entry) i.next();
            String meNumber = (String) me.getValue();
            if (meNumber.equalsIgnoreCase(number)) {

                String nameFound = (String) me.getKey();
                return nameFound;

            }

        }
        String noRecord = "There is no record of that number in the phone-book";
        return noRecord;

    }
}
