package com.elibrary.utils;


public enum LibraryMessage {

    APPLICATION_INFO("dbLibrary database application"),

    INVALID_CREDENTIALS("Invalid credentials please verify your password / registration number."),
    NO_CREDENTIALS("Please provide your password / registration number."),
    NO_PASSWORD("Please provide your password."),
    NO_REGISTRATION_NUMBER("Please provide your registration number.");

    private String message;

    LibraryMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
