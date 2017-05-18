

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mollyarant on 5/16/17.
 */
public class PhoneBook {

    private String contactName;
    private String phoneNumber;

   private TreeMap<String, ArrayList<String>> contactInfo= new TreeMap();

    public TreeMap<String, ArrayList<String>> getContactInfo() {
        return contactInfo;
    }



    public ArrayList<String> lookup(String contactName, TreeMap<String, ArrayList<String>> contactInfo ){
        return contactInfo.get(contactName);
    }


    public TreeMap addEntry(String contactName, String phoneNumber, TreeMap<String, ArrayList<String>> contactInfo){
            if (doesNumberExistInContactInfo(contactName,contactInfo)){
                contactInfo.get(contactName).add(phoneNumber);
            }
            else{
                addNewEntry(contactName, phoneNumber, contactInfo);
            }
            return contactInfo;
    }



    public void removeRecord(String contactName, TreeMap<String, ArrayList<String>> contactInfo){
        contactInfo.remove(contactName);

    }

    public void removeNumber(String contactName, String phoneNumber, TreeMap<String, ArrayList<String>> contactInfo){
        if(doesNumberExistInContactInfo(contactName,contactInfo)){
            contactInfo.get(contactName).remove(contactInfo.get(contactName).indexOf(phoneNumber));
        }
        else {
            System.out.println("The number does not exist");
        }

    }



    public String listAllEntries(TreeMap<String, ArrayList<String>> contactInfo){
        String allEntries = "";
        for (Map.Entry<String, ArrayList<String>> entry : contactInfo.entrySet()) {
            allEntries+= ("\n"+ "Name: " + entry.getKey() + " Phone Number: " + entry.getValue());
        }

        return allEntries.trim();
    }


    public String listAllNames(TreeMap<String, ArrayList<String>> contactInfo){
        String allEntries= "";
        for (Map.Entry<String, ArrayList<String>> entry: contactInfo.entrySet()){
            allEntries+=("\n"+ "Name: " + entry.getKey());
        }
        return allEntries.trim();
    }

    private boolean doesNumberExistInContactInfo(String contactName, TreeMap<String, ArrayList<String>> contactInfo){
        return contactInfo.containsKey(contactName);
    }

    private void addNewEntry(String contactName, String phoneNumber, TreeMap<String, ArrayList<String>> contactInfo){
        ArrayList<String> numbers= new ArrayList<String>();
        numbers.add(phoneNumber);
        contactInfo.put(contactName, numbers);
    }

}
