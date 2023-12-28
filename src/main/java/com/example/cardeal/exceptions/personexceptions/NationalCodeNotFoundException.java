package com.example.cardeal.exceptions.personexceptions;

import com.example.cardeal.exceptions.ServiceException;

import javax.sql.rowset.serial.SerialException;

public class NationalCodeNotFoundException extends ServiceException {
    public NationalCodeNotFoundException() {
    }

    public NationalCodeNotFoundException(String message) {
        super(message);
    }

    public NationalCodeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NationalCodeNotFoundException(Throwable cause) {
        super(cause);
    }

    public NationalCodeNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
