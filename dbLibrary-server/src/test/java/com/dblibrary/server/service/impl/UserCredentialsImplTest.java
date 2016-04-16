package com.dblibrary.server.service.impl;

import com.dblibrary.client.common.dto.Credentials;
import com.dblibrary.client.common.dto.User;
import com.dblibrary.server.dao.UserDao;
import com.dblibrary.server.dao.entity.UserEntity;
import com.dblibrary.server.utils.LibraryException;
import com.dblibrary.server.utils.LibraryMessage;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class UserCredentialsImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserDao studentDAO;

    @InjectMocks
    private UserCredentialsImpl studentCredentials;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerifyStudentCredentialsNull() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_CREDENTIALS.getMessage());

        studentCredentials.verifyUserCredentials(null);
    }

    @Test
    public void testVerifyStudentNoCredentials() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_CREDENTIALS.getMessage());

        Credentials credentials = new Credentials();
        credentials.setPassword("");
        credentials.setRegistration("");

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentNoPassword() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_PASSWORD.getMessage());

        Credentials credentials = new Credentials();
        credentials.setPassword("");
        credentials.setRegistration("registrationNumber");

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentNoRegistrationNumber() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_REGISTRATION_NUMBER.getMessage());

        Credentials credentials = new Credentials();
        credentials.setPassword("password");
        credentials.setRegistration("");

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentInvalidCredentials() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.INVALID_CREDENTIALS.getMessage());

        Credentials credentials = new Credentials();
        credentials.setPassword("password");
        credentials.setRegistration("registrationNumber");

        when(studentDAO.verifyCredentials("", credentials.getPassword())).thenReturn(new UserEntity());

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentValidCredentials() throws Exception {
        Credentials credentials = new Credentials();
        credentials.setPassword("password");
        credentials.setRegistration("registration1234");

        UserEntity entity = new UserEntity();
        entity.setUserId(12345L);
        entity.setUserName("name");
        entity.setUserEmail("user@lib.ro");
        entity.setPhoneNumber(072146566L);

        when(studentDAO.verifyCredentials(credentials.getRegistration(), credentials.getPassword())).thenReturn(entity);

        User actual = studentCredentials.verifyUserCredentials(credentials);

        assertEquals(entity.getUserId(), actual.getUserId());
        assertEquals(entity.getUserName(), actual.getUserName());
        assertEquals(entity.getUserEmail(), actual.getUserEmail());
        assertEquals(entity.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(entity.getUserType(), actual.getUserType());
    }
}