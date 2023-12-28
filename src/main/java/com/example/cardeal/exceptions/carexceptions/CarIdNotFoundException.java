package com.example.cardeal.exceptions.carexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class CarIdNotFoundException extends ServiceException {
    public CarIdNotFoundException() {
    }

    public CarIdNotFoundException(String message) {
        super(message);
    }

    public CarIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarIdNotFoundException(Throwable cause) {
        super(cause);
    }

    public CarIdNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
