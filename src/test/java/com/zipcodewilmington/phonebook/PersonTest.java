package com.zipcodewilmington.phonebook;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by pat on 2/12/18.
 */
public class PersonTest {

    Person bill;
    Person otherBill;
    Person emptyMan;

    @Before
    public void setup(){
        bill = new Person("bill", "1234567890");
        otherBill = new Person("bill", "123", "456");
        emptyMan = new Person("NO NAME", "000000000");
    }

    @Test
    public void setNameTest(){
        bill.setName("jeremy");
        Assert.assertEquals("jeremy", bill.getName());
    }

    @Test
    public void setMultipleNumberTest(){
        bill.setNumbers("123", "456");
        Assert.assertEquals(bill.getNumbers(), otherBill.getNumbers());
    }


}
