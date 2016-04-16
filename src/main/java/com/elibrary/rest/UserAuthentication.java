package com.elibrary.rest;


import com.elibrary.service.UserCredentials;
import com.elibrary.service.dto.Credentials;
import com.elibrary.utils.LibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class UserAuthentication {

    @Autowired
    @Qualifier("userCredentials")
    UserCredentials userCredentials;

    @POST
    @Path("/credentials")
    @Produces("application/json")
    public Response authenticateUser(Credentials credentials) {
        try {
            return Response.ok(userCredentials.verifyUserCredentials(credentials)).build();
        } catch (LibraryException exception) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(exception.getMessage()).type(MediaType.TEXT_PLAIN).build();
        }
    }
}
