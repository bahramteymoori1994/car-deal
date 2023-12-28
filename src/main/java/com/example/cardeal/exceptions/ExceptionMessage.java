package com.example.cardeal.exceptions;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class ExceptionMessage
{
    private boolean statusError;
    private String message;
    private LocalDateTime localDateTime;
}