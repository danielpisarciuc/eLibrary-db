package com.dblibrary.client.impl;

import com.dblibrary.client.LibraryDbClient;
import com.dblibrary.common.dto.Credentials;
import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class LibraryDbClientImpl implements LibraryDbClient {

    private String dbLibraryUrl;
    private Client client;
    private String authenticateUser;

    public LibraryDbClientImpl(String dbLibraryUrl) {
        this.dbLibraryUrl = dbLibraryUrl;
        this.authenticateUser = this.dbLibraryUrl + "/" + "authentication/credentials";
    }

    @Override
    public Response authenticateUser(Credentials credentials) {
        client = ClientBuilder.newClient(new ClientConfig().register(Response.class));
        WebTarget target = client.target(this.authenticateUser);
        Response response = target.request().post(Entity.json(credentials));

        return response;
    }

}
