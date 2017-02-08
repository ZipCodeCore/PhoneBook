import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ryangross on 2/7/17.
 */
public class PhoneBookTest {
    PhoneBook aPH;

    @Before
    public void setUp() {
        aPH = new PhoneBook();
      //  aPH.add("Ryan Gross", "123-456-7890");

    }

    public PhoneBook getaPH() {
        return aPH;
    }

    @Test
    public void addTest() {
    //    aPH.add("Ryan Gross", "555-555-5555");
        Assert.assertEquals(2, aPH.getPh().get("Ryan Gross").size());
    }

    @Test
    public void lookupTest() {
        Assert.assertEquals("123-456-7890", aPH.lookUp("Ryan Gross"));
    }

    @Test
    public void removeTest() {
        aPH.remove("Ryan Gross");
        Assert.assertFalse(aPH.containsKey("Ryan Gross"));
    }

    @Test
    public void reverseLookUpTest() {
     //   aPH.add("Ryan Gross", "555-555-5555");

        Assert.assertEquals("Ryan Gross", aPH.reverseLookUp("123-456-7890"));
        // Check through whole array.
        Assert.assertEquals("Ryan Gross", aPH.reverseLookUp("555-555-5555"));
    }

}
