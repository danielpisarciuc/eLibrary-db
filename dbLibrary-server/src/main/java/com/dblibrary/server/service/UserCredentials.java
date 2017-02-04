package com.dblibrary.server.service;

import com.dblibrary.common.dto.Credentials;
import com.dblibrary.common.dto.User;
import com.dblibrary.server.utils.LibraryException;

public interface UserCredentials {

    /**
     * Verify the user credentials.
     *
     * @param credentials the object used for user authentication
     * @return user object information's otherwise throws LibraryException
     * @throws LibraryException if any
     */
    User verifyUserCredentials(Credentials credentials) throws LibraryException;
}
