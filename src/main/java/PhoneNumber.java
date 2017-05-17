import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class PhoneNumber
{
    private String phoneNumber;

    public PhoneNumber(){}

    public PhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException
    {
        setPhoneNumber(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidPhoneNumberFormatException
    {
        //validate phone number with format `(###)-###-####`
        if (!phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
        {
            throw new InvalidPhoneNumberFormatException();
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }


}
