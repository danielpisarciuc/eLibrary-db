package com.elibrary.service;

import com.elibrary.service.dto.Credentials;
import com.elibrary.service.dto.User;
import com.elibrary.utils.LibraryException;
import org.springframework.stereotype.Component;

public interface UserCredentials {

    User verifyUserCredentials(Credentials credentials) throws LibraryException;
}
