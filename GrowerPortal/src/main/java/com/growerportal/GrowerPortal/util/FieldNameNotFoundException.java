package com.growerportal.GrowerPortal.util;

public class FieldNameNotFoundException extends RuntimeException {
    public FieldNameNotFoundException(Long id) {
        super(String.format("Cannot find the Field Name with ID: %s", id));
    }
}
