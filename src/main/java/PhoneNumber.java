import com.sun.jdi.InvalidTypeException;

import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/16/17.
 */
public class PhoneNumber
{
    private String name;
    private String phoneNumber;
    private ArrayList<PhoneBook> myPhoneFactory;

    public PhoneNumber(){}

    public PhoneNumber(String name, String phoneNumber) throws InvalidTypeException
    {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
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

    public int compareTo(PhoneNumber p)
    {
            return this.getName().compareTo(p.getName());
    }


}
