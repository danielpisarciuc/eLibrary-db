package com.dblibrary.common.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Credentials {
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
