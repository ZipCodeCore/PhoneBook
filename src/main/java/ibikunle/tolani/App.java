package ibikunle.tolani;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by tolaniibikunle on 2/7/17.
 */
public class App {
   static PhoneBook phoneBook = new PhoneBook();
    public static void main(String[] args) throws InvalidPhoneNumberFormatException {
        phoneBook.add("Tolani","612-121-1211");
        phoneBook.add("Dan","419-419-4419");
        phoneBook.add("Dan","419-419-5656");

        phoneBook.add ("milton","419-419-5656");
        phoneBook.listAllEntries();



    }


}
