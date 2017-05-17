package com.zipcodewilmington;

import java.io.IOException;

public final class RecordNotFoundException extends IOException {

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}
