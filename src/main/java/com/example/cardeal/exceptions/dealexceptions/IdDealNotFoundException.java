package com.example.cardeal.exceptions.dealexceptions;

import com.example.cardeal.exceptions.ServiceException;

public class IdDealNotFoundException extends ServiceException {
    public IdDealNotFoundException() {
    }

    public IdDealNotFoundException(String message) {
        super(message);
    }

    public IdDealNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdDealNotFoundException(Throwable cause) {
        super(cause);
    }

    public IdDealNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
