package com.elibrary.service.business.mappers;

import com.elibrary.service.dto.User;
import com.elibrary.service.entity.UserEntity;

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
