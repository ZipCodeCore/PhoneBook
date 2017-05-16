package io.github.aaronclong.holdingobjects;

import org.junit.Test;

/**
 * Created by aaronlong on 5/16/17.
 */
public class InvalidNumberExceptionTest {
  @Test(expected = InvalidNumberException.class)
  public void testInvalidNumberExceptionIsThrowable() throws InvalidNumberException {
    throw new InvalidNumberException();
  }
}
