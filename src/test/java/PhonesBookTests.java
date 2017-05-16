import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cameronsima on 5/16/17.
 */
public class PhonesBookTests {

    @Test
    public void addPhoneNumberTest() {
        PhoneBook phonebook = new PhoneBook();
        String name = "Cameron Sima";
        String phoneNumber = "2154673127";

        phonebook.add(name, phoneNumber);

        Assert.assertEquals(1, phonebook.listAllEntries().length);

    }

}
