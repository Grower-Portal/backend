package com.growerportal.GrowerPortal.util;

public class FarmNotFoundException extends RuntimeException {
    public FarmNotFoundException(Long farmId) {
        super(STR."Farm not found with ID: \{farmId}");
    }
}
