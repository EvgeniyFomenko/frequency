package com.example.frequency.exception;

import com.example.frequency.dto.ExceptionMessage;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class ErrorController {


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public ExceptionMessage validateSizeException(final HandlerMethodValidationException validationException) {
        return ExceptionMessage.builder().message("Введена строка меньше 1 символа или больше 200 символов")
                .error(validationException.getMessage()).build();
    }
}
