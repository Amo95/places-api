package com.service.place.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class NotFoundException extends RuntimeException {
    private String message;


    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }
}
