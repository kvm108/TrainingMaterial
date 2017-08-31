package com.spring.SpringRestMongoDemo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.spring.SpringRestMongoDemo.collections.UserCollection;

public interface UserRepository extends 
			MongoRepository<UserCollection, String>{
	
	@Query(value="{uname: ?0}")
	public List<UserCollection> getUsersByName(String name);
}






