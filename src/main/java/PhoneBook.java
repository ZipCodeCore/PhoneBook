

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mollyarant on 5/16/17.
 */
public class PhoneBook {

    private String contactName;
    private String phoneNumber;

    private TreeMap<String, String> contactInfo= new TreeMap<String, String>();

    public TreeMap<String, String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(TreeMap<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }



    public String lookup(String contactName){
        return contactInfo.get(contactName);
    }

    public void addEntry(String contactName, String phoneNumber){
            contactInfo.put(contactName, phoneNumber);
    }

    public void removeEntry(String contactName){
        contactInfo.remove(contactName);

    }

    public String listAllEntries(){
        String allEntries = "";
        for (Map.Entry<String, String> entry : contactInfo.entrySet()) {
            allEntries+= ("\n"+ "Name: " + entry.getKey() + " Phone Number: " + entry.getValue());
        }

        return allEntries.trim();
    }

    public String listAllNames(){
        String allEntries= "";
        for (Map.Entry<String, String> entry: contactInfo.entrySet()){
            allEntries+=("\n"+ "Name: " + entry.getKey());
        }
        return allEntries.trim();
    }


    public String reverseLookUp(String phoneNumber){
        String nameOfContact="";
        for (Map.Entry<String, String> entry : contactInfo.entrySet()) {
            if (entry.getValue().equals(phoneNumber)) {
                nameOfContact += entry.getKey();
            }

        }
        return nameOfContact;
    }




}
