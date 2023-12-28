package com.example.cardeal.exceptions.personexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class FamilyNotFoundException extends ServiceException
{
    public FamilyNotFoundException() {
    }

    public FamilyNotFoundException(String message) {
        super(message);
    }

    public FamilyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FamilyNotFoundException(Throwable cause) {
        super(cause);
    }

    public FamilyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}