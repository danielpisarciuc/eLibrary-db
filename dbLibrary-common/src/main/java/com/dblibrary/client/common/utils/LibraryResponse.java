package com.dblibrary.client.common.utils;


public enum LibraryResponse {

    INTERNAL_SERVER_ERROR("dbLibrary application internal server error");

    private String message;

    LibraryResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
