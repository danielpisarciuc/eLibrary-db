package com.elibrary.mappers;

import com.elibrary.service.dto.User;
import com.elibrary.dao.entity.UserEntity;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class LibraryMapperTest {

    @Mock
    private LibraryMapper mapper;

    @Test
    public void testUserEntityToDto() throws Exception {
        UserEntity expected = mockUserEntity();

        User actual = mapper.userEntityToDto(expected);

        assertEquals(expected.getUserId(), actual.getUserId());
        assertEquals(expected.getUserName(), actual.getUserName());
        assertEquals(expected.getUserEmail(), actual.getUserEmail());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getUserType(), actual.getUserType());
    }

    private UserEntity mockUserEntity() {
        UserEntity expected = new UserEntity();
        expected.setUserId(12345L);
        expected.setUserName("dbLibrary");
        expected.setUserEmail("dummy@lib.com");
        expected.setPhoneNumber(58436581L);
        expected.setUserType("STUDENT");
        return expected;
    }
}