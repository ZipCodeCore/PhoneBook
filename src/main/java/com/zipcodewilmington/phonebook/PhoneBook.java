package com.zipcodewilmington.phonebook;
import javax.naming.Context;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    protected TreeMap<String, Listing> book;

    public PhoneBook(String nameKey, Listing firstListing) {
        this.book = new TreeMap<String, Listing>();
        book.put(nameKey, firstListing);
    }

    public void addListing(String listingKeyToAdd, Listing listingValueToAdd) {
        book.put(listingKeyToAdd, listingValueToAdd);
    }

    public void removeListing(String listingKeyToRemove) throws Exception {
        if (book.get(listingKeyToRemove) == null) {
            throw new Exception("No listing under that name: cannot remove");
        }
        book.remove(listingKeyToRemove);
    }

    public String lookupByName(String keyToLookup) throws Exception {
        if (book.get(keyToLookup) == null) {
            throw new Exception("No listing under that name: cannot look up");
        }
        return book.get(keyToLookup).printNumbers();
    }

    public String listAllNames() {
        StringBuilder builder = new StringBuilder();
        Set keys = book.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            builder.append(book.get(key).printName() + "\n");
        }
        return builder.toString();
    }

    public String listAllNamesAndNumbers() {
        StringBuilder builder = new StringBuilder();
        Set keys = book.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            String nameToPrint = book.get(key).printName();
            String numbersToPrint = book.get(key).printNumbers();
            builder.append(String.format("%8s : %8s", nameToPrint, numbersToPrint + "\n"));
        }
        return builder.toString();
    }

    public String reverseLookup(String numberToLookup) {
        Set keys = book.keySet();
        for (Iterator i = keys.iterator(); i.hasNext(); ) {
            String key = (String) i.next();
            String numbersList = book.get(key).printNumbers();
            String[] numbersArray = numbersList.split(" | ");
            for (int j = 0; j < numbersArray.length; j++) {
                if (numberToLookup.equals(numbersArray[j])){
                    return book.get(key).printName();
                }
            }
        }
        return "Number not found in directory";
    }







    public static void main(String[] args) {
        Listing eric = new Listing("Eric", "555-5555");
        Listing jenny = new Listing("Jenny", "867-5309");
        Listing horatio = new Listing("Horatio", "987-6543");
        Listing terrance = new Listing("Terrance", "111-2222");
        Listing tariq = new Listing("Tariq", "420-6969");
        PhoneBook test = new PhoneBook ("Jenny", jenny);
        test.addListing("Eric", eric);
        test.addListing("Horatio", horatio);
        test.addListing("Terrance", terrance);
        test.addListing("Tariq", tariq);
        horatio.addNumber("111-1111");
        tariq.addNumber("123-4567");
        tariq.addNumber("987-6543");

      Set keys = test.book.keySet();
        for (Iterator i = keys.iterator(); i.hasNext();) {
            String key = (String) i.next();
            String nameToPrint = test.book.get(key).printName();
            String numbersToPrint = test.book.get(key).printNumbers();
            System.out.printf("%8s : %8s", nameToPrint, numbersToPrint +"\n");

        }

    }

}
