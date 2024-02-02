package com.growerportal.GrowerPortal.util;

public class FieldNameNotFoundException extends RuntimeException {
    public FieldNameNotFoundException(Long id) {
        super(STR."Can not find the Field Name with Id: \{id}");
    }
}
