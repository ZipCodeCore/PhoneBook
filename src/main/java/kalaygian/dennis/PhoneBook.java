package kalaygian.dennis;

import java.util.HashMap;
import java.util.ArrayList;


/**
 * Created by denniskalaygian on 5/16/17.
 */
public class PhoneBook{

    private HashMap<String, ArrayList<PhoneNumber>> phoneCatalog;

    public PhoneBook(){
        phoneCatalog = new HashMap<String, ArrayList<PhoneNumber>>();
    }

    public PhoneBook(HashMap<String, ArrayList<PhoneNumber>> phoneCatalog){
        this.phoneCatalog = phoneCatalog;
    }

    public HashMap<String, ArrayList<PhoneNumber>> getPhoneCatalog(){
        return phoneCatalog;
    }

    public void addPhoneNumber(String person, ArrayList<PhoneNumber> phoneNumbers){
        phoneCatalog.put(person, phoneNumbers);
    }

    public void removeFromCatalog(String person){
        ArrayList<PhoneNumber> personToDelete = phoneCatalog.get(person);
        if(personToDelete != null){
            phoneCatalog.remove(person);
        }else{
            System.out.println("Name not in phone book.");
        }
    }

    public String lookUp(String person) throws NullPointerException{
        ArrayList<PhoneNumber> returnedNumbers = phoneCatalog.get(person);
        String answer = "";
        if(returnedNumbers != null){
            return findNumber(returnedNumbers, answer);
        }else{
            throw throwNameNullPointer();
        }
    }

    private String findNumber(ArrayList<PhoneNumber> numbers, String answer){
        for(PhoneNumber number: numbers){
            answer = answer.concat(number.getNumber()).concat("\n");
        }
        return answer;
    }

    private NullPointerException throwNameNullPointer() throws NullPointerException{
        System.out.println("Name not in phoneBook");
        return new NullPointerException();
    }

    public String listAllEntries(){
        String returnString = "";
        for(String person : phoneCatalog.keySet()){
            returnString = returnString.concat(person);
            returnString = returnString.concat(":");
            for(PhoneNumber num : phoneCatalog.get(person)){
                returnString = returnString.concat(" ").concat(num.getNumber());
            }
            returnString = returnString.concat("\n");
        }
        return returnString;
    }

    public String reverseLookup(String phoneNumber) throws NullPointerException{
        String returnName = null; // Instantiate as null
            for(String name : phoneCatalog.keySet()){ // Iterate through names in tree map (phone book)
               for(PhoneNumber num : phoneCatalog.get(name)){ // Iterate through phone numbers associated with a particular name
                   if (num.getNumber().equals(phoneNumber)){ // Compare the individual number in question with what youre searching for
                       returnName = name.concat("\n"); // If they're the same, assign it to the return variable
                   }
               }
            }
            if(returnName == null){ // If you never found the number
                System.out.println("Number not in phonebook"); // Tell them that
                throw new NullPointerException(); // Throw a nullPointerException
            }
            return returnName; // If the exception wasn't thrown, return the name
    }

}
