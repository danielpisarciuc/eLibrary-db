package com.dblibrary.server.controller;

import com.dblibrary.common.dto.Credentials;
import com.dblibrary.common.dto.User;
import com.dblibrary.server.service.UserCredentials;
import com.dblibrary.server.utils.LibraryException;
import com.dblibrary.server.utils.LibraryMessage;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserAuthenticationTest extends JerseyTest {

    @Mock
    private UserCredentials userCredentials;

    @Override
    public Application configure() {
        return new ResourceConfig(UserAuthentication.class);
    }

    @Test
    public void testGet() {
        assertThat(target().getUri().getPort(), not(0));
        assertThat(getBaseUri().getPort(), not(0));
    }

    @Test
    public void testAuthenticateUserUnauthorized() throws LibraryException {
        when(userCredentials.verifyUserCredentials(mockCredentials())).thenThrow(new LibraryException(LibraryMessage.NO_CREDENTIALS.getMessage()));

        Response response = target("authentication/credentials").request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(mockCredentials()));

        assertEquals((Response.Status.UNAUTHORIZED).getStatusCode(), response.getStatus());
        assertEquals(MediaType.TEXT_PLAIN, String.valueOf(response.getMediaType()));

    }

    @Test
    @Ignore
    public void testAuthenticateUserOk() throws LibraryException {
        User expected = User.builder()
                .id(1234L)
                .name("userName")
                .email("user@lib.ro")
                .phoneNumber(72341511L)
                .type("ADMIN")
                .build();

        Credentials credentials = mockCredentials();

        when(userCredentials.verifyUserCredentials(credentials)).thenReturn(expected);

        Response response = target("authentication/credentials").request().post(Entity.entity(credentials, MediaType.APPLICATION_JSON));
        assertEquals((Response.Status.OK).getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, String.valueOf(response.getMediaType()));

        User actual = response.readEntity(User.class);

        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getName(), actual.getName());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getType(), actual.getType());
    }

    private Credentials mockCredentials() {
        return Credentials.builder()
                .password("pass1234")
                .registration("1234Registration")
                .build();
    }
}