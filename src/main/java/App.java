/**
 * Created by brianmullin on 5/16/17.
 */
public class App {

    public static void(String[] args){

        PhoneBook book = new PhoneBook();

        book.addEntries("brian", "1800");

        System.out.println(book.lookUpByName("brian"));
    }
}
