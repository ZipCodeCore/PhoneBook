/**
 * Created by sarahweisser on 5/16/17.
 */
public class Entry {

    private String name;
    private String formattedPhoneNumber;
    private String phoneNumber;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFormattedPhoneNumber() {
        return formattedPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber = formatPhoneNumber(phoneNumber);
    }

    public String formatPhoneNumber(String phoneNumber) {
        formattedPhoneNumber = "(" + phoneNumber.substring(0, 3) + ") " + phoneNumber.substring(3, 6) + "-"
                + phoneNumber.substring(6, 10);
        return formattedPhoneNumber;
    }

    public Entry(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.formattedPhoneNumber = formatPhoneNumber(phoneNumber);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + formattedPhoneNumber;
    }

}
