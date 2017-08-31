package com.spring.SpringRestMongoDemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import com.spring.SpringRestMongoDemo.collections.UserCollection;
import com.spring.SpringRestMongoDemo.entity.User;
import com.spring.SpringRestMongoDemo.repository.UserRepository;

public class UserMongoDAOImpl implements UserDAO {

	@Autowired
	UserRepository userRepository;
	
	public User createUser(User user) {
		UserCollection userCollection = new UserCollection();
		userCollection.setFname(user.getFname());
		userCollection.setPwd(user.getPwd());
		userCollection.setUname(user.getUname());
		System.out.println("Inside DAO ");
		userRepository.save(userCollection);
		return user;
	}

}
