package kalaygian.dennis;

/**
 * Created by denniskalaygian on 5/16/17.
 */
public class PhoneNumber{

    private String number;

    public PhoneNumber(String number) throws InvalidPhoneNumberFormatException{
        if(!number.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")){
            throw new InvalidPhoneNumberFormatException();
        }
        this.number = number;
    }

    public String getNumber(){
        return number;
    }

    public void setNumber(String number){
        this.number = number;
    }

}
