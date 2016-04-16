package com.elibrary.service.dao.impl;

import com.elibrary.service.dao.config.AbstractDao;
import com.elibrary.service.dao.UserDao;
import com.elibrary.service.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserEntity verifyCredentials(String registration, String password) {
        Criteria criteria = getSession().createCriteria(UserEntity.class);

        criteria.add(Restrictions.eq("registration", registration));
        criteria.add(Restrictions.eq("password", password));

        return (UserEntity) criteria.uniqueResult();
    }
}
