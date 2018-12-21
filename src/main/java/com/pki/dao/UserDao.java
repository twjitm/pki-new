package com.pki.dao;

import com.pki.base.BaseDao;
import com.pki.entity.User;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao extends BaseDao<User> {

}
