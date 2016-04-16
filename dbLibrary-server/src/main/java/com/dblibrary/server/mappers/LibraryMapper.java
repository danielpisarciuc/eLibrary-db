package com.dblibrary.server.mappers;

import com.dblibrary.server.dao.entity.UserEntity;
import com.dblibrary.client.common.dto.User;

/**
 * Map an object dto to an entity and vice versa
 */
public class LibraryMapper {

    public static User userEntityToDto(UserEntity entity) {
        User dto = new User();

        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setUserEmail(entity.getUserEmail());
        dto.setPhoneNumber(entity.getPhoneNumber());
        dto.setUserType(entity.getUserType());

        return dto;
    }
}
