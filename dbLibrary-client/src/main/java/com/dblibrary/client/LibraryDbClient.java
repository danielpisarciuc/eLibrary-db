package com.dblibrary.client;


import com.dblibrary.common.dto.Credentials;

import javax.ws.rs.core.Response;

public interface LibraryDbClient {

    Response authenticateUser(Credentials credentials);
}
