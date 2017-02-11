package jackson.rick;

/**
 * Created by rickjackson on 2/10/17.
 */
public class InvalidPhoneNumberFormatException extends NumberFormatException {
    
    public InvalidPhoneNumberFormatException() {
    }
    
    public InvalidPhoneNumberFormatException(String s) {
        super(s);
    }
}
