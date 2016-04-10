package com.elibrary.service.dao;

import com.elibrary.service.entity.UserEntity;

public interface UserDao {

    UserEntity verifyCredentials(String registration, String password);
}
