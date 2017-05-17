import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by andrewwong on 5/16/17.
 */
public class PhoneNumberFactoryTests {

//    @Test (expected = InvalidPhoneNumberFormatException.class)
//    public void testInvalidPhoneNumberFormatException(){
//        PhoneNumberFactory.createPhoneNumber("123");
//    }

    @Test
    public void testCreatePhoneNumberSafely(){
        //Given
        int areaCode = 0;
        int centralOfficeCode = 0;
        int phoneLineCode = 0;
        //When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
        //Then
        assertNull(phoneNumber);
    }

    @Test
    public void testGetAreaCode() {
        // : Given
        Integer areaCode = 302;
        int centralOfficeCode = 312;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getAreaCode(), areaCode.toString());
    }

    @Test
    public void testGetCentralOfficeCode() {
        // : Given
        int areaCode = 302;
        Integer centralOfficeCode = 312;
        int phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getCentralOfficeCode(), centralOfficeCode.toString());
    }


    @Test
    public void testGetPhoneLineCode() {
        // : Given
        int areaCode = 302;
        int centralOfficeCode = 312;
        Integer phoneLineCode = 5555;

        // : When
        PhoneNumber phoneNumber = PhoneNumberFactory.createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);

        // : Then
        Assert.assertEquals(phoneNumber.getPhoneLineCode(), phoneLineCode.toString());
    }
}
