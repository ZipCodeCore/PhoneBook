import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 Some people have more than one phone number. Refactor your PhoneBook class to map names to lists of phone numbers.
 You should modify your add() and remove() methods to handle adding or removing individual numbers, and create a
 removeRecord method for removing an entire entry from your PhoneBook.


 * Created by vidyachandasekhar on 5/16/17.
 */
public class PhoneBook {


    private Map<String, Set<String>> phoneMap = new TreeMap();
    private Map<String, String> reversePhoneMap = new HashMap();


    public void addEntry(String name, String number) {
        if (phoneMap.get(name) == null){
            phoneMap.put(name, new HashSet());
        }
        Set phoneNumberSet = phoneMap.get(name);
        phoneNumberSet.add(number);
        reversePhoneMap.put(number,name);

    }

    public void deleteEntry(String name) {
        Set<String> phoneNumberSet = phoneMap.get(name);
        if (phoneNumberSet == null){
            return;
        }
        phoneMap.remove(name);
        for (String phoneNumber: phoneNumberSet){
            reversePhoneMap.remove(phoneNumber);
        }

    }

    public String lookUpName(String name) {
        Set<String>  phoneNumberSet =phoneMap.get(name);
        return   getPhoneNumber(phoneNumberSet);
    }

    private String getPhoneNumber(Set<String> phoneNumberSet){
        if (phoneNumberSet == null){
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String phoneNumber : phoneNumberSet){
            stringBuilder.append(" "+ phoneNumber +" ");
        }
        return stringBuilder.toString().trim();
    }

    public String lookUpAllEntries() {

        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Set<String>> entry : phoneMap.entrySet()) {
            stringBuilder.append(("Name : " + entry.getKey() + " Phone Number : " + getPhoneNumber(entry.getValue()) + "\n"));
        }
        return stringBuilder.toString();
    }


    public String reverseLookupNumber(String number){
        return reversePhoneMap.get(number);
    }

}




