package com.elibrary.rest;

import com.elibrary.service.UserCredentials;
import com.elibrary.service.dto.Credentials;
import com.elibrary.service.dto.User;
import com.elibrary.utils.ApplicationContextUtils;
import com.elibrary.utils.LibraryException;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.DeploymentContext;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class UserAuthenticationTest extends JerseyTest {

    private UserCredentials userCredentials;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        userCredentials = (UserCredentials) ApplicationContextUtils.getApplicationContext().getBean("userCredentials");
        assertNotNull(userCredentials);
    }

    @Override
    protected DeploymentContext configureDeployment() {
        forceSet(TestProperties.CONTAINER_PORT, "0");
        ResourceConfig resourceConfig = new ResourceConfig(UserAuthentication.class);
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        resourceConfig.property("contextConfigLocation", "classpath:mockApplicationContext.xml");
        return DeploymentContext.builder(resourceConfig).build();
    }

    @Test
    public void testGet() {
        assertThat(target().getUri().getPort(), not(0));
        assertThat(getBaseUri().getPort(), not(0));
    }

    @Test
    public void testAuthenticateUserUnauthorized() throws LibraryException {
        when(userCredentials.verifyUserCredentials(any(Credentials.class))).thenThrow(LibraryException.class);

        Response response = target("authentication/credentials").request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(mockCredentials()), Response.class);

        assertEquals((Response.Status.UNAUTHORIZED).getStatusCode(), response.getStatus());
        assertEquals(MediaType.TEXT_PLAIN, String.valueOf(response.getMediaType()));

    }

    @Test
    public void testAuthenticateUserOk() throws LibraryException {
        User expected = new User();
        expected.setUserId(1234L);
        expected.setUserName("userName");
        expected.setUserEmail("user@lib.ro");
        expected.setPhoneNumber(072341511L);
        expected.setUserType("ADMIN");

        when(userCredentials.verifyUserCredentials(any(Credentials.class))).thenReturn(expected);

        Response response = target("authentication/credentials").request().accept(MediaType.APPLICATION_JSON_TYPE).post(Entity.json(mockCredentials()), Response.class);
        assertEquals((Response.Status.OK).getStatusCode(), response.getStatus());
        assertEquals(MediaType.APPLICATION_JSON, String.valueOf(response.getMediaType()));

        User actual =  response.readEntity(User.class);

        assertEquals(expected.getUserId(), actual.getUserId());
        assertEquals(expected.getUserName(), actual.getUserName());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getUserEmail(), actual.getUserEmail());
        assertEquals(expected.getUserType(), actual.getUserType());
    }

    private Credentials mockCredentials() {
        Credentials credentials = new Credentials();
        credentials.setPassword("pass1234");
        credentials.setRegistration("1234Registration");

        return credentials;
    }
}