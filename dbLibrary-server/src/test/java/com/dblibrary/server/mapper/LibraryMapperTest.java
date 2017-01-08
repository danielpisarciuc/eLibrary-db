package com.dblibrary.server.mapper;

import com.dblibrary.common.dto.User;
import com.dblibrary.server.dao.entity.UserEntity;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryMapperTest {

    @Test
    public void testUserEntityToDto() throws Exception {
        UserEntity expected = mockUserEntity();

        User actual = LibraryMapper.userEntityToDto(expected);

        assertEquals(expected.getUserId(), actual.getId());
        assertEquals(expected.getUserName(), actual.getName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.getPhoneNumber(), actual.getPhoneNumber());
        assertEquals(expected.getType(), actual.getType());
    }

    private UserEntity mockUserEntity() {
        return UserEntity.builder()
                .userId(12345L)
                .userName("dbLibrary")
                .email("dummy@lib.com")
                .phoneNumber(58436581L)
                .type("STUDENT")
                .build();
    }
}