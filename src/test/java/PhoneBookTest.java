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
        aPH.add("Ryan Gross", "302-393-6344");
    }

    @Test
    public void addTest() {
        Assert.assertTrue(aPH.containsKey("Ryan Gross"));
        Assert.assertTrue(aPH.containsValue("302-393-6344"));
    }

    @Test
    public void lookupTest() {
        Assert.assertEquals("302-393-6344", aPH.lookUp("Ryan Gross"));
    }

    @Test
    public void removeTest() {
        aPH.remove("Ryan Gross");
        Assert.assertFalse(aPH.containsKey("Ryan Gross"));
    }

    @Test
    public void reverseLookUpTest() {
        Assert.assertEquals("Ryan Gross", aPH.reverseLookUp("302-393-6344"));
    }

}
