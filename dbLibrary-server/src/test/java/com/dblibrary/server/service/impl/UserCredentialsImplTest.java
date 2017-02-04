package com.dblibrary.server.service.impl;

import com.dblibrary.common.dto.Credentials;
import com.dblibrary.common.dto.User;
import com.dblibrary.server.dao.UserDao;
import com.dblibrary.server.dao.entity.UserEntity;
import com.dblibrary.server.utils.LibraryException;
import com.dblibrary.server.utils.LibraryMessage;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserCredentialsImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Mock
    private UserDao studentDAO;

    @InjectMocks
    private UserCredentialsImpl studentCredentials;

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

        Credentials credentials = Credentials.builder()
                .password("")
                .registration("")
                .build();

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentNoPassword() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_PASSWORD.getMessage());

        Credentials credentials = Credentials.builder()
                .password("")
                .registration("registrationNumber")
                .build();

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentNoRegistrationNumber() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.NO_REGISTRATION_NUMBER.getMessage());

        Credentials credentials = Credentials.builder()
                .password("password")
                .registration("")
                .build();

        studentCredentials.verifyUserCredentials(credentials);
    }

    @Test
    public void testVerifyStudentInvalidCredentials() throws LibraryException {
        expectedException.expect(LibraryException.class);
        expectedException.expectMessage(LibraryMessage.INVALID_CREDENTIALS.getMessage());

        Credentials credentials = Credentials.builder()
                .password("password")
                .registration("registrationNumber")
                .build();

        when(studentDAO.verifyCredentials("", credentials.getPassword())).thenReturn(UserEntity.builder().build());

        studentCredentials.verifyUserCredentials(credentials);

        verify(studentDAO).verifyCredentials("", credentials.getPassword());
    }

    @Test
    public void testVerifyStudentValidCredentials() throws Exception {
        Credentials credentials = Credentials.builder()
                .password("password")
                .registration("registration1234")
                .build();

        UserEntity entity = UserEntity.builder()
                .userId(12345L)
                .userName("name")
                .email("user@lib.ro")
                .phoneNumber(72146566L)
                .type("ADMIN")
                .build();

        when(studentDAO.verifyCredentials(credentials.getRegistration(), credentials.getPassword())).thenReturn(entity);

        User actual = studentCredentials.verifyUserCredentials(credentials);

        assertEquals(entity.getUserId(), actual.getId());
        assertEquals(entity.getUserName(), actual.getName());
        assertEquals(entity.getEmail(), actual.getEmail());
        assertEquals(entity.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(entity.getType(), actual.getType());

        verify(studentDAO).verifyCredentials(credentials.getRegistration(), credentials.getPassword());
        verifyNoMoreInteractions(studentDAO);
    }
}