package com.elibrary.controller;

import com.elibrary.utils.LibraryMessage;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;

public class ApplicationInfoTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(ApplicationInfo.class);
    }

    @Test
    public void testVerifyRESTService() throws Exception {
        Response response = target("app/info").request().get();
        String actual = response.readEntity(String.class);

        assertEquals((Response.Status.OK).getStatusCode(), response.getStatus());
        assertEquals(MediaType.TEXT_PLAIN, String.valueOf(response.getMediaType()));
        assertEquals(LibraryMessage.APPLICATION_INFO.getMessage(), actual);
    }
}