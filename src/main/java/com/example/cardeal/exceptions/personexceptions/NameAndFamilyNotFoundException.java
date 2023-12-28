package com.example.cardeal.exceptions.personexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class NameAndFamilyNotFoundException extends ServiceException
{
    public NameAndFamilyNotFoundException() {
    }

    public NameAndFamilyNotFoundException(String message) {
        super(message);
    }

    public NameAndFamilyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameAndFamilyNotFoundException(Throwable cause) {
        super(cause);
    }

    public NameAndFamilyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}