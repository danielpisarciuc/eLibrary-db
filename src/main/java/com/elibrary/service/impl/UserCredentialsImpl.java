package com.elibrary.service.impl;

import com.elibrary.dao.UserDao;
import com.elibrary.dao.entity.UserEntity;
import com.elibrary.service.UserCredentials;
import com.elibrary.service.dto.Credentials;
import com.elibrary.service.dto.User;
import com.elibrary.utils.LibraryException;
import com.elibrary.utils.LibraryMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.elibrary.mappers.LibraryMapper.userEntityToDto;

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
            return userEntityToDto(userEntity);
        } else {
            LOGGER.error(LibraryMessage.INVALID_CREDENTIALS.getMessage());
            throw new LibraryException(LibraryMessage.INVALID_CREDENTIALS.getMessage());
        }
    }
}
