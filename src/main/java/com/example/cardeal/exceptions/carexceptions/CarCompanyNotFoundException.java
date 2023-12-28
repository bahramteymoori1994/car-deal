package com.example.cardeal.exceptions.carexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class CarCompanyNotFoundException extends ServiceException {
    public CarCompanyNotFoundException() {
    }

    public CarCompanyNotFoundException(String message) {
        super(message);
    }

    public CarCompanyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarCompanyNotFoundException(Throwable cause) {
        super(cause);
    }

    public CarCompanyNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
