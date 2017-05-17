import com.sun.jdi.AbsentInformationException;
import com.sun.jdi.InvalidTypeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class testPhoneBook
{
    private PhoneBook myBook;
    private PhoneNumber dave;
    private PhoneNumber paco;
    private PhoneNumber tina;

    @Before
    public void setUp() throws InvalidTypeException
    {
        myBook = new PhoneBook();
        dave = new PhoneNumber("Dave", "1231231234");
        paco = new PhoneNumber("Paco", "8434508649");
        tina = new PhoneNumber("Tina", "4562341234");
        myBook.myPhoneMap.put(dave.getName(), dave.getPhoneNumber());

    }

    @Test
    public void testAdd()
    {
        //Given
        myBook.addNumber(paco);
        myBook.addNumber(tina);
        int expected = 3;

        //when
        int actual = myBook.myPhoneMap.size();

        //then
        Assert.assertEquals("created 3 phoneNumbers", expected, actual);
    }

    @Test
    public void testCreateAndAddNumberSearchNumber()
    {
        //given
        myBook.addNumber("Alla", "8434575004");
        String expected = "8434575004";

        //when
        String actual = myBook.lookUp("Alla");

        //then
        Assert.assertEquals("Set a phone number and should return phone", expected, actual);
    }

    @Test
    public void testRemove()
    {
        //Given
        myBook.addNumber(paco);
        myBook.addNumber(tina);
        myBook.remove("Dave");
        int expected = 2;

        //when
        int actual = myBook.myPhoneMap.size();

        //then
        Assert.assertEquals("created 3 phoneNumbers and removed 1", expected, actual);
    }

    @Test
    public void testAllNames()
    {
        //given
        myBook.addNumber(tina);
        myBook.addNumber(paco);
        String expected ="Dave \nPaco\nTina\n";

        //when
        String actual = myBook.listAllNames();

        //then
        Assert.assertEquals("print out two numbers", expected, actual);
    }

    @Test
    public void testAllEntries()
    {
        //given
        myBook.addNumber(tina);
        myBook.addNumber(paco);
        String expected ="Dave 1231231234\nPaco 8434508649\nTina 4562341234\n";

        //when
        String actual = myBook.listAllEntries();

        //then
        Assert.assertEquals("print out two numbers", expected, actual);
    }

    @Test
    public void testCreateAndAddNumberSearchName()
    {
        //given
        myBook.addNumber("Alla", "8434575004");
        String expected = "Alla";

        //when
        String actual = myBook.lookUpName("8434575004");

        //then
        Assert.assertEquals("Set a phone number and should return phone", expected, actual);
    }




}
