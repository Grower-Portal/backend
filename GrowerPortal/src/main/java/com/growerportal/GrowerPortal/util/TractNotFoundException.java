package com.growerportal.GrowerPortal.util;

public class TractNotFoundException extends RuntimeException {
    public TractNotFoundException(Long tractId) {
        super(String.format("Tract not found with ID: %d", tractId));
    }
}
