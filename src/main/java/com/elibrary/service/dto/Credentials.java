package com.elibrary.service.dto;


public class Credentials {

    private String registration;
    private String password;


    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
