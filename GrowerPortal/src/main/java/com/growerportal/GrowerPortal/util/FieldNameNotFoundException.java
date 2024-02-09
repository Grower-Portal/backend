package com.growerportal.GrowerPortal.util;

public class FieldNameNotFoundException extends RuntimeException {
    public FieldNameNotFoundException(Long id) {
        super(String.format("Can not find the Field Name with Id: %d", id));
    }
}
