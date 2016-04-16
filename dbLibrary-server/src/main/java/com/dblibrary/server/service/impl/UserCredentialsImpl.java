package com.dblibrary.server.service.impl;

import com.dblibrary.client.common.dto.Credentials;
import com.dblibrary.server.dao.entity.UserEntity;
import com.dblibrary.server.mappers.LibraryMapper;
import com.dblibrary.client.common.dto.User;
import com.dblibrary.server.dao.UserDao;
import com.dblibrary.server.service.UserCredentials;
import com.dblibrary.server.utils.LibraryException;
import com.dblibrary.server.utils.LibraryMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("userCredentials")
public class UserCredentialsImpl implements UserCredentials {

    private final Logger LOGGER = Logger.getLogger(UserCredentialsImpl.class);

    @Autowired
    UserDao userDao;

    public User verifyUserCredentials(Credentials credentials) throws LibraryException {
        if (credentials == null || credentials.hasValidCredentials()) {
            LOGGER.error(LibraryMessage.NO_CREDENTIALS.getMessage());
            throw new LibraryException(LibraryMessage.NO_CREDENTIALS.getMessage());
        }

        if (credentials.hasValidPassword()) {
            LOGGER.error(LibraryMessage.NO_PASSWORD.getMessage());
            throw new LibraryException(LibraryMessage.NO_PASSWORD.getMessage());
        } else if (credentials.hasValidRegistration()) {
            LOGGER.error(LibraryMessage.NO_REGISTRATION_NUMBER.getMessage());
            throw new LibraryException(LibraryMessage.NO_REGISTRATION_NUMBER.getMessage());
        }

        UserEntity userEntity = userDao.verifyCredentials(credentials.getRegistration(), credentials.getPassword());

        if (userEntity != null) {
            return LibraryMapper.userEntityToDto(userEntity);
        } else {
            LOGGER.error(LibraryMessage.INVALID_CREDENTIALS.getMessage());
            throw new LibraryException(LibraryMessage.INVALID_CREDENTIALS.getMessage());
        }
    }
}
