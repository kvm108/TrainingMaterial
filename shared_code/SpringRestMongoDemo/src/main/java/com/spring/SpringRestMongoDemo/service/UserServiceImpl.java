package com.spring.SpringRestMongoDemo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.SpringRestMongoDemo.dao.UserDAO;
import com.spring.SpringRestMongoDemo.entity.User;

public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDao;
	
	public User createUser(User user) {
		return userDao.createUser(user);
	}

}
