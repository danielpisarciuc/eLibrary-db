package com.elibrary.dao;

import com.elibrary.dao.entity.UserEntity;

public interface UserDao {

    UserEntity verifyCredentials(String registration, String password);
}
