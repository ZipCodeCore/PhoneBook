import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by randallcrame on 2/7/17.
 */
public class PhoneBook {



    private TreeMap<String, ArrayList<String>> addressBook = new TreeMap<>();

    public TreeMap<String, ArrayList<String>> getAddressBook() {
        return addressBook;
    }

    public String lookUp(String K){
        if (addressBook.isEmpty())
            return "List Empty";
        else if (K.length() > 32)
            return "String > 32 characters";
        else if (addressBook.containsKey(K)){
            String list ="";
            for (String value : addressBook.get(K))
                list += value +"\n";
            return list;
        }
        return "Name not listed";
    }

    public String add(String K, String V){
        if (!addressBook.containsKey(K)){
            ArrayList<String> list = new ArrayList<>();
            addressBook.put(K, list);
        }

        if (K.length() < 32) {
            addressBook.get(K).add(V);
        } else return "String > 32 characters";
        return K + " added";
    }
    public String remove(String K, String V){
        if (addressBook.isEmpty())
            return "List Empty";
        else if (K.length() > 32)
            return "String > 32 characters";
        else if (addressBook.containsKey(K)) {
            for (Map.Entry<String, ArrayList<String>> entry : addressBook.entrySet()) {
                String key = entry.getKey();
                for (String value : addressBook.get(key)) {
                    if (V.equals(value)) {
                        addressBook.get(key).remove(value);
                        return "Removed Entry";
                    }
                }
            }
        }
            return "Name not listed";
    }
    public String removeRecord(String K){
        if (addressBook.isEmpty())
            return "List Empty";
        else if (K.length() > 32)
            return "String > 32 characters";
        else if (addressBook.containsKey(K)) {
            addressBook.remove(K);
            return K + "removed";
        } else
            return "Name not listed";
    }

    public String printNameList(){
        if (addressBook.isEmpty())
            return "List is empty";
        else {
            String list = "";
            for (Map.Entry<String, ArrayList<String>> entry : addressBook.entrySet()) {
                String key = entry.getKey();
                list += key + "\n";
            }
        return list;
        }
    }

    public String printEntryList(){
        if (addressBook.isEmpty())
            return "List is empty";
        else {
            String list = "";
            for (Map.Entry<String, ArrayList<String>> entry : addressBook.entrySet()) {
                String key = entry.getKey();
                String value = lookUp(entry.getKey());
                list += String.format("%s :\n %s\n", key, value);
            }
            return list;
        }    }

    public String reverseLookUp(String V){
        if (addressBook.isEmpty())
            return "List is empty";
        else if (V.length() > 32)
            return "String > 32 characters";
        else {
            for (Map.Entry<String, ArrayList<String>> entry : addressBook.entrySet()) {
                String key = entry.getKey();
                for (String value : addressBook.get(key)) {
                    if (V.equals(value))
                        return key;
                }
            }

        }
            return "Name not listed";
    }
}
