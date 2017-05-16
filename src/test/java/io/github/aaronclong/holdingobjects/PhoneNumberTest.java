package io.github.aaronclong.holdingobjects;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by aaronlong on 5/16/17.
 */
public class PhoneNumberTest {
    @Test
    public void checkNumberConstruction() {
        PhoneNumber num = PhoneNumber.registerNumber(200, 300, 4000);
        assertTrue("Confirming number Construction", num instanceof PhoneNumber);
    }
}
