import com.sun.jdi.InvalidTypeException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class testPhoneNumber
{
    PhoneNumber myPhoneNumber = new PhoneNumber();
    String name;


    @Test
    public void testPhoneNumber() throws InvalidTypeException
    {
        //given
        String phoneNumber = "8434508649";
        myPhoneNumber.setPhoneNumber(phoneNumber);
        String expected = phoneNumber;

        //when
        String actual = myPhoneNumber.getPhoneNumber();

        //then
        Assert.assertEquals("Set the phoneNumber to phoneBook", expected, actual);

    }

    @Test(expected = InvalidTypeException.class)
    public void testPhoneNumberWithException() throws InvalidTypeException
    {
        //given
        String phoneNumber = "843450864";
        myPhoneNumber.setPhoneNumber(phoneNumber);

    }



}
