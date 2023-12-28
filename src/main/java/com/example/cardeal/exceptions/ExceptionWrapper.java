package com.example.cardeal.exceptions;

import com.example.cardeal.exceptions.carexceptions.CarCompanyNotFoundException;
import com.example.cardeal.exceptions.carexceptions.CarNotFoundException;
import com.example.cardeal.exceptions.personexceptions.*;
import com.example.cardeal.model.entities.Car;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ExceptionWrapper
{
    @ExceptionHandler(ServiceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(ServiceException serviceException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        switch( serviceException.getClass().getSimpleName() )
        {
            case "PersonIdNotFoundException":
                exceptionMessage.setStatusError(true);
                exceptionMessage.setMessage("Person Id Not Found");
                exceptionMessage.setLocalDateTime(LocalDateTime.now());
                break;

            case "CarIdNotFoundException":
                exceptionMessage.setStatusError(true);
                exceptionMessage.setMessage("Car Id Not Found");
                exceptionMessage.setLocalDateTime(LocalDateTime.now());
                break;

            case "IdDealNotFoundException":
                exceptionMessage.setStatusError(true);
                exceptionMessage.setMessage("Deal Id Not Found");
                exceptionMessage.setLocalDateTime(LocalDateTime.now());
                break;
        }

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(NoSuchElementException noSuchElementException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage(noSuchElementException.getLocalizedMessage());
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(ConstraintViolationException constraintViolationException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Field is Null...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Field is Blank...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(SQLIntegrityConstraintViolationException sqlIntegrityConstraintViolationException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Unique field is duplicated...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(NameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(NameNotFoundException nameNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("First name Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(FamilyNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(FamilyNotFoundException familyNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Family name Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(NameAndFamilyNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(NameAndFamilyNotFoundException nameAndFamilyNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Name and Family Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(MethodArgumentTypeMismatchException methodArgumentTypeMismatchException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        switch (methodArgumentTypeMismatchException.getPropertyName())
        {
            case "role":
                exceptionMessage.setStatusError(true);
                exceptionMessage.setMessage("Person Role Not Found");
                exceptionMessage.setLocalDateTime(LocalDateTime.now());
                break;

            case "carModel":
                exceptionMessage.setStatusError(true);
                exceptionMessage.setMessage("Car Model Not Found");
                exceptionMessage.setLocalDateTime(LocalDateTime.now());
                break;
        }

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(NationalCodeNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(NationalCodeNotFoundException nationalCodeNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("National Code Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(PhoneNumberNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(PhoneNumberNotFoundException phoneNumberNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Phone Number Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(EmailNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(EmailNotFoundException emailNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Email Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(CarNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(CarNotFoundException carNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Car Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }

    @ExceptionHandler(CarCompanyNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<ExceptionMessage> exceptionHandler(CarCompanyNotFoundException carCompanyNotFoundException)
    {
        ExceptionMessage exceptionMessage = new ExceptionMessage();

        exceptionMessage.setStatusError(true);
        exceptionMessage.setMessage("Car Company Not Found...!");
        exceptionMessage.setLocalDateTime(LocalDateTime.now());

        return ResponseEntity.badRequest().body(exceptionMessage);
    }
}