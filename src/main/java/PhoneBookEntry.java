import org.junit.Test;

/**
 * Created by jarrydstamatelos on 5/16/17.
 */
public class PhoneBookEntry {

    private String name;
    private String phoneNumber;
    private String formattedPhoneNumber;

    public PhoneBookEntry(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber = "(" + phoneNumber.substring(0,3) + ") " + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6,10);
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setFormattedPhoneNumber(String formattedPhoneNumber) {
        this.formattedPhoneNumber = formattedPhoneNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "Name : " + this.getName() + "\nPhone Number : " + this.getFormattedPhoneNumber();
    }



}
