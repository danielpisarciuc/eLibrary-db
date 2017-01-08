package com.dblibrary.server.mapper;

import com.dblibrary.server.dao.entity.UserEntity;
import com.dblibrary.common.dto.User;

/**
 * Map an object dto to an entity and vice versa
 */
public class LibraryMapper {

    public static User userEntityToDto(UserEntity userEntity) {

        return User.builder()
                .id(userEntity.getUserId())
                .type(userEntity.getType())
                .name(userEntity.getUserName())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }
}
