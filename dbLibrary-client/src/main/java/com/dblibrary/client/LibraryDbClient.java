package com.dblibrary.client;


import com.dblibrary.client.common.dto.Credentials;

import javax.ws.rs.core.Response;

public interface LibraryDbClient {

    public Response authenticateUser(Credentials credentials);
}
