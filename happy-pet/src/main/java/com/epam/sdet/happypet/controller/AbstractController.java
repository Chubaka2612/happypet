package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.exception.*;
import com.epam.sdet.happypet.response.wrapper.ExceptionResponse;
import com.epam.sdet.happypet.response.wrapper.ItemResponse;
import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import com.epam.sdet.happypet.util.ResponseCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Objects;

public class AbstractController {

    @ExceptionHandler(DeleteException.class)
    protected ResponseEntity<ExceptionResponse> handleDeleteException(DeleteException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ResponseCode.VALIDATION_FAILED_ERROR,
                        ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ExceptionResponse> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ExceptionResponse(ResponseCode.NOT_FOUND_ERROR,
                ex.getMessage()));
    }

    @ExceptionHandler(CreateException.class)
    protected ResponseEntity<ExceptionResponse> handleCreateException(CreateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ResponseCode.VALIDATION_FAILED_ERROR,
                        ex.getMessage()));
    }

    @ExceptionHandler(UpdateException.class)
    protected ResponseEntity<ExceptionResponse> handleUpdateException(UpdateException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ResponseCode.VALIDATION_FAILED_ERROR,
                        ex.getMessage()));
    }

    @ExceptionHandler(InvalidInputParameterException.class)
    protected ResponseEntity<ExceptionResponse> handleWrongParameterException(InvalidInputParameterException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ResponseCode.VALIDATION_FAILED_ERROR,
                ex.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorMessage.append(String.format("field: %s, value: '%s', message: %s; ",
                    fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage()));
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errorMessage.append(String.format("%s: %s; ", error.getObjectName(), error.getDefaultMessage()));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionResponse(ResponseCode.VALIDATION_FAILED_ERROR,
                        "Invalid values: " + errorMessage.toString()));
    }

    protected <T> ResponseEntity<ItemResponse> getResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new NotFoundException("Resource was not found");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemResponse(ResponseCode.SUCCESS, result));
    }

    protected <T> ResponseEntity<ItemsResponse> getResponseEntityList(List<T> results) {
        if (results.isEmpty() || results == null) {
            throw new NotFoundException("Resource was not found");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemsResponse(ResponseCode.SUCCESS, results));
    }

    protected <T> ResponseEntity<T> deleteResponseEntityObject() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    protected <T> ResponseEntity<ItemResponse> postResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new InvalidInputParameterException("Invalid input parameters");
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ItemResponse(ResponseCode.CREATED, result));
    }

    protected <T> ResponseEntity<ItemResponse> putResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new InvalidInputParameterException("Invalid input parameters");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemResponse(ResponseCode.SUCCESS, result));
    }
}