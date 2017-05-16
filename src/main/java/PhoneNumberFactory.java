/**
 * Created by andrewwong on 5/16/17.
 */
public class PhoneNumberFactory {
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException{
        return new PhoneNumber(phoneNumberString);
    }
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode){
        String phoneNumberString = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException e) {
            //log that it was an invalid phoneNumber
            return null;
        }
    }
}
