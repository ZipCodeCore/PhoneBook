package com.markbrown.holdingobjects;

import java.io.IOException;

/**
 * Created by markbrown on 5/16/17.
 */
public class InvalidInputException extends IllegalArgumentException {

    public InvalidInputException(String message) {
        super(message);
    }

}
