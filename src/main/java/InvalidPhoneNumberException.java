/**
 * Created by ryangross on 2/7/17.
 */
public class InvalidPhoneNumberException extends Exception{
    String wrongNumber;

    public InvalidPhoneNumberException(String aString) {
        wrongNumber = aString;
    }


}
