package com.growerportal.GrowerPortal.util;

public class TractNotFoundException extends RuntimeException {
    public TractNotFoundException(Long tractId) {
        super(STR."Tract not found with ID: \{tractId}");
    }
}
