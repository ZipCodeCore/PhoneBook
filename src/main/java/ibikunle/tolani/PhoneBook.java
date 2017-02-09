package ibikunle.tolani;

import com.sun.media.sound.InvalidFormatException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import static com.sun.corba.se.spi.activation.IIOP_CLEAR_TEXT.value;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class PhoneBook extends TreeMap< String,ArrayList> {

    public String lookUp(String name) {

        return this.get(name).toString(); // you cant cast an array into a string you need to call the method in order to do the same function
    }


    public String reverseLookUp(String number) throws InvalidPhoneNumberFormatException {
        String value = "";
        try {
            if (!number.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")) {
                throw new InvalidPhoneNumberFormatException();
                }
                for (Object keys : this.keySet()) {
                    for (Object numbers : this.get(keys)) {// look through the keys saying we now have access to the to values from the key
                        if (number.equals(numbers)) { //checking to see if the the number you are passing through equals the number at the key value
                            value = keys.toString(); //then you are setting value equal to that number and returning the number /the value of that number
                        }
                    }
                }

        }
        catch (InvalidPhoneNumberFormatException e) {
            System.out.println("Invalid Phone number");
        } return value;
    }

    public void add(String name, String phoneNumber) throws InvalidPhoneNumberFormatException {

        try {
            if(!phoneNumber.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")){
                throw new InvalidPhoneNumberFormatException();
            }

        // check if name is in the phone book if  at the is there the add number if not add a key and value to the phone book.

        if  (this.get(name)!=null) {
            // if the size of the array is not equal zero or the value at the value is not equal to null. its already in the book.
            this.get(name).add(phoneNumber); // this is adding the value to the original Arraylist in the tree map
        } else {
            ArrayList<String> listOfNumbers = new ArrayList<String>();  // if this value is not in the arraylist add it to this new array list..
            listOfNumbers.add(phoneNumber);
            this.put(name, listOfNumbers); //putting these key value pairs inside of the treeMAP arraylist.
        }
    }
    catch (InvalidPhoneNumberFormatException e){
        System.out.println("Invalid Phone number");
    }
    }

    public void removeEntry(String name) {
        this.remove(name);


    }

    public void removeASingleNumber(String phoneNumber) throws InvalidPhoneNumberFormatException {
        try {
            if(!phoneNumber.matches("^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$")){
                throw new InvalidPhoneNumberFormatException();
            }


   for(Object key : this.keySet()){//here we are iterating through the treeMap, to get to all of the keys, which now gives us access to the values at those keys
       Iterator temporayHolderItr = this.get(key).iterator(); // making the arraylist iterator, which allows us to now gives us the ability to iterate through the arraylist and  remove a value

         while(temporayHolderItr.hasNext())// while the arraylist has a next value
         if(temporayHolderItr.next().equals(phoneNumber)){ //this temporaryholder.next is equal to a value and it comes the phonenumber we are passing through to the next number in the arraylist.
            temporayHolderItr.remove(); //the iterator is removing phonenumber equal to the value at temporaryHolder.itr.
            }

       }
    }
    catch (InvalidPhoneNumberFormatException e){
        System.out.println("Invalid Phone number");
    }
    }

    public void listAllNames() {

        for (Object key : this.keySet()) { // this is printing all of the keys essentially the list names in the keySet
            System.out.println(key);
        }

    }

    public void listAllEntries() {
        for (Object key : this.keySet()) {
            System.out.println(key + " " + this.get(key)); // this prints the key and values . this. get key prints all the values.
        }
    }
}