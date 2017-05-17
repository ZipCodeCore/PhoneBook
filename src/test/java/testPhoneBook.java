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
        dave = new PhoneNumber("1231231234");
        paco = new PhoneNumber( "8434508649");
        tina = new PhoneNumber("4562341234");

    }

    @Test
    public void testAdd()
    {
        //Given
        myBook.addNumber("Paco", paco.getPhoneNumber());
        myBook.addNumber("Dave", dave.getPhoneNumber());
        int expected = 2;

        //when
        int actual = myBook.myPhoneMap.size();

        //then
        Assert.assertEquals("created 2 phoneNumbers", expected, actual);
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
        myBook.addNumber("Paco", paco.getPhoneNumber());
        myBook.addNumber("Tina", tina.getPhoneNumber());
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
        myBook.addNumber("Tina", tina.getPhoneNumber());
        myBook.addNumber("Paco", paco.getPhoneNumber());
        String expected ="Paco\nTina\n";

        //when
        String actual = myBook.listAllNames();

        //then
        Assert.assertEquals("print out two numbers", expected, actual);
    }

    @Test
    public void testAllEntries()
    {
        //given
        myBook.addNumber("Tina", tina.getPhoneNumber());
        myBook.addNumber("Paco", paco.getPhoneNumber());
        String expected ="Paco 8434508649\nTina 4562341234\n";

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
        String actual = myBook.reverseLookUp("8434575004");

        //then
        Assert.assertEquals("Set a phone number and should return phone", expected, actual);
    }

    @Test
    public void testRemoveBySearch()
    {
        //given
        myBook.addNumber("Alla", "8434575004");
        myBook.addNumber("Alla", "8434575222");

        String expected = "8434575222";

        //when
        String actual =  myBook.removeNumberBySearch("8434575004");

        //then
        Assert.assertEquals(expected, actual);
    }
}
