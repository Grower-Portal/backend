package com.growerportal.GrowerPortal.util;

import java.security.SecureRandom;

public class SecurityUtility {
    public static String generateOtp() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        return String.format("%05d", num);
    }

    // ... other utility methods ...
}
