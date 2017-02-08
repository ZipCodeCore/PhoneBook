package collins.john;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by johncollins on 2/7/17.
 */
public class EntriesTest {

    Entries testEntries;
    @Before
    public void setUp(){
       testEntries = new Entries("222-666-8888");
    }
    @Test
    public void getNumbersTest(){
        String actual = testEntries.getNumbers().toString();
        //String expected = "[222-666-8888]";
        String expected = "fail";//fail test
        assertEquals("should return test phone number", expected, actual);
    }


}
