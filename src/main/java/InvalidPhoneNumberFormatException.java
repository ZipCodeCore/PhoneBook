import sun.jvm.hotspot.jdi.IntegerValueImpl;

import java.io.IOException;

/**
 * Created by aurorabanuelos on 5/17/17.
 */
public class InvalidPhoneNumberFormatException extends IOException  {

    public InvalidPhoneNumberFormatException() {
    }
    public InvalidPhoneNumberFormatException(String gripe) {
        super(gripe);
    }

}
