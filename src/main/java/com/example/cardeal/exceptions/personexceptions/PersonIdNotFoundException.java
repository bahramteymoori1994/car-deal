package com.example.cardeal.exceptions.personexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class PersonIdNotFoundException extends ServiceException
{
    public PersonIdNotFoundException() {
    }

    public PersonIdNotFoundException(String message) {
        super(message);
    }

    public PersonIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonIdNotFoundException(Throwable cause) {
        super(cause);
    }

    public PersonIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}