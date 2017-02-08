import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by eugenevendensky on 2/7/17.
 */
public class EntryTest {


    Entry entry;

    @Before
    public void setUp(){entry = new Entry("215-676-1408");}
    @Test
    public void addNumberTest(){
        entry.addPhoneNumber("215-676-2222");
        String actual = entry.getNumber(1);
        String expected = "215-676-2222";
        assertEquals(actual, expected);
    }
    @Test
    public void getAllNumbersTest(){
        entry.addPhoneNumber("215-676-2222");
        String actual = entry.getNumbers();
        String expected = "[215-676-1408, 215-676-2222]";
        assertEquals(actual, expected);
    }



}
