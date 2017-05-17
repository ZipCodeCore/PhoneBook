import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class PhoneNumber
{
    private String phoneNumber;

    public PhoneNumber(){}

    public PhoneNumber(String phoneNumber) throws InvalidTypeException
    {
        setPhoneNumber(phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) throws InvalidTypeException
    {
        int phoneLength = String.valueOf(phoneNumber).length();
        if(phoneLength != 10)
        {
            throw new InvalidTypeException();
        }
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }


}
