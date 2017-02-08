package ries.dan;

/**
 * Created by danries on 2/7/17.
 */
public class App {

    static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args){
        phoneBook.addEntry("Carmelo","(302)999-6565");
        phoneBook.addEntry("Carmelo","(302)888-6565");
        phoneBook.addEntry("Travis","(555)555-5555");
        phoneBook.addEntry("Corey","(666)666-6666");

        phoneBook.listAllNames();
        System.out.println("");
        phoneBook.listAllEntries();
    }

}
