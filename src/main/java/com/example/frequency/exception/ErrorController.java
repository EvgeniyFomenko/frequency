package com.example.frequency.exception;

import com.example.frequency.dto.ExceptionMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ErrorController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ExceptionMessage validateSizeException(final ValidationException validationException) {
        return ExceptionMessage.builder().message("Введена строка меньше 1 символа или больше 200 символов")
                .error(validationException.getMessage()).build();
    }
}
