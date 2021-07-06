package com.epam.sdet.happypet.controller;

import com.epam.sdet.happypet.exception.*;
import com.epam.sdet.happypet.response.wrapper.ItemResponse;
import com.epam.sdet.happypet.response.wrapper.ItemsResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AbstractController {

    private static final String NO_FOUND = "Resource was not found";
    private static final String INVALID_INPUT = "Invalid input parameters";

    protected <T> ResponseEntity<ItemResponse> getResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new NotFoundException(NO_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemResponse(result));
    }

    protected <T> ResponseEntity<ItemsResponse> getResponseEntityList(List<T> results) {
        if (results.isEmpty() || results == null) {
            throw new NotFoundException(NO_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemsResponse(results));
    }

    protected <T> ResponseEntity<ItemsResponse> getResponseEntityList(Map<List<T>, Long> results) {
        if (results.isEmpty() || results == null) {
            throw new NotFoundException(NO_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemsResponse(results.keySet().iterator().next(),
                        (long)results.values().toArray()[0]));
    }

    protected <T> ResponseEntity<T> deleteResponseEntityObject() {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

    protected <T> ResponseEntity<ItemResponse> postResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new InvalidInputParameterException(INVALID_INPUT);
        }
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ItemResponse(result));
    }

    protected <T> ResponseEntity<ItemResponse> putResponseEntityObject(T result) {
        if (Objects.isNull(result)) {
            throw new InvalidInputParameterException(INVALID_INPUT);
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ItemResponse(result));
    }
}