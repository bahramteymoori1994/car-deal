package com.example.cardeal.exceptions.personexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class PhoneNumberNotFoundException extends ServiceException {
    public PhoneNumberNotFoundException() {
    }

    public PhoneNumberNotFoundException(String message) {
        super(message);
    }

    public PhoneNumberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PhoneNumberNotFoundException(Throwable cause) {
        super(cause);
    }

    public PhoneNumberNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
