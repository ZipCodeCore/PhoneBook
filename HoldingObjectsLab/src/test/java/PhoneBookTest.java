import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertEquals;
/**
 * Created by eugenevendensky on 2/7/17.
 */
public class PhoneBookTest {

    PhoneBook phoneBook;

    @Before
    public void setUp() {
         phoneBook = new PhoneBook();
    }

    @Test
    public void phoneBookLookUp() {
        Contact john = new Contact("John", "215-676-1408");
        Contact amy = new Contact("Amy", "215-676-5402");
        Contact alex = new Contact("Alex", "215-314-3311");
        Contact herp = new Contact("Herp", "215-222-1972");
        Contact derp = new Contact("Derp", "215-484-1989");

        phoneBook.phoneBook.put(john.name, john.number);
        phoneBook.phoneBook.put(amy.name, amy.number);
        phoneBook.phoneBook.put(alex.name, alex.number);
        phoneBook.phoneBook.put(herp.name, john.number);
        phoneBook.phoneBook.put(derp.name, derp.number);
        String actual = phoneBook.lookUp("Amy");
        String expected = "215-676-5402";
        assertEquals(expected, actual);
    }

    @Test
    public void phoneBookReverseLookUp() {
        Contact john = new Contact("John", "215-676-1408");
        Contact amy = new Contact("Amy", "215-676-5402");
        Contact alex = new Contact("Alex", "215-314-3311");
        Contact herp = new Contact("Herp", "215-222-1972");
        Contact derp = new Contact("Derp", "215-484-1989");

        phoneBook.phoneBook.put(john.name, john.number);
        phoneBook.phoneBook.put(amy.name, amy.number);
        phoneBook.phoneBook.put(alex.name, alex.number);
        phoneBook.phoneBook.put(herp.name, john.number);
        phoneBook.phoneBook.put(derp.name, derp.number);
        String actual = phoneBook.reverseLookUp("215-676-1408");
        String expected = "John";
        assertEquals(expected, actual);
    }
    @Test
    public void phoneBookPrintAll(){

        Contact john = new Contact("John", "215-676-1408");
        Contact amy = new Contact("Amy", "215-676-5402");
        Contact alex = new Contact("Alex", "215-314-3311");
        Contact herp = new Contact("Herp", "215-222-1972");
        Contact derp = new Contact("Derp", "215-484-1989");

        phoneBook.phoneBook.put(john.name, john.number);
        phoneBook.phoneBook.put(amy.name, amy.number);
        phoneBook.phoneBook.put(alex.name, alex.number);
        phoneBook.phoneBook.put(herp.name, john.number);
        phoneBook.phoneBook.put(derp.name, derp.number);
        phoneBook.printAllNumbersAndContacts();
    }
    @Test
    public void addAContactTest(){
        phoneBook.addAContact("Sammy", "1-800-CRAZYGIRLFRIENDS");
        String actual = phoneBook.phoneBook.get("Sammy");
        String expected = "1-800-CRAZYGIRLFRIENDS";
        assertEquals(actual, expected);
    }
    @Test
    public void removeAContactTest(){
        phoneBook.addAContact("Sammy", "1-800-CRAZYGIRLFRIENDS");
        phoneBook.removeAContact("Sammy");
        String actual = phoneBook.phoneBook.get("Sammy");
        String expected = null;
        assertEquals(actual, expected);
    }
}
