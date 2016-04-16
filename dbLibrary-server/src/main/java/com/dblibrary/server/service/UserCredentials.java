package com.dblibrary.server.service;

import com.dblibrary.client.common.dto.Credentials;
import com.dblibrary.client.common.dto.User;
import com.dblibrary.server.utils.LibraryException;

public interface UserCredentials {

    User verifyUserCredentials(Credentials credentials) throws LibraryException;
}
