package com.dblibrary.server.dao;

import com.dblibrary.server.dao.entity.UserEntity;

public interface UserDao {

    UserEntity verifyCredentials(String registration, String password);
}
