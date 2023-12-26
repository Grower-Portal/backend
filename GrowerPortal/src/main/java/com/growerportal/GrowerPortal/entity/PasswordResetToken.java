package com.growerportal.GrowerPortal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Entity
public class PasswordResetToken {

    private static final int EXPIRATION = 3; // 15 minutes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    private String otp;

    @Temporal(TemporalType.TIMESTAMP)
    @Setter
    private Date expiryDate;

    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    public PasswordResetToken() {}

    public PasswordResetToken(String otp, User user) {
        this.otp = otp;
        this.user = user;
        this.expiryDate = calculateExpiryDate();
    }

    public Date calculateExpiryDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, PasswordResetToken.EXPIRATION);
        return new Date(cal.getTime().getTime());
    }

    // Getters and setters...

    public boolean isExpired() {
        return new Date().after(this.expiryDate);
    }

}
