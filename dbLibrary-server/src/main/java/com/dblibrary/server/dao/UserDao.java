package com.dblibrary.server.dao;

import com.dblibrary.server.dao.entity.UserEntity;

public interface UserDao {

    /**
     * Verify user credentials based on given registration / password values.
     *
     * @param registration the user registration value
     * @param password     the user password value
     * @return user entity object otherwise null
     */
    UserEntity verifyCredentials(String registration, String password);
}
