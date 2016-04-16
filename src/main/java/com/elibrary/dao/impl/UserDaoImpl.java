package com.elibrary.dao.impl;

import com.elibrary.dao.UserDao;
import com.elibrary.dao.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    public UserEntity verifyCredentials(String registration, String password) {
        Criteria criteria = getSession().createCriteria(UserEntity.class);

        criteria.add(Restrictions.eq("registration", registration));
        criteria.add(Restrictions.eq("password", password));

        return (UserEntity) criteria.uniqueResult();
    }
}
