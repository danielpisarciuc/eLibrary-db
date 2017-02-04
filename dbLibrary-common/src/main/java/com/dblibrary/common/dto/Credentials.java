package com.dblibrary.common.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credentials implements Serializable {
    @NonNull
    private String registration;

    @NonNull
    private String password;

    public boolean hasValidRegistration() {
        return registration == null || registration.isEmpty();
    }

    public boolean hasValidPassword() {
        return password == null || password.isEmpty();
    }

    public boolean hasValidCredentials() {
        return hasValidRegistration() && hasValidPassword();
    }

}
