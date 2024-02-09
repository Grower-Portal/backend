package com.growerportal.GrowerPortal.util;

public class FarmNotFoundException extends RuntimeException {
    public FarmNotFoundException(Long farmId) {
        super(String.format("Farm not found with ID: %d", farmId));
    }
}
