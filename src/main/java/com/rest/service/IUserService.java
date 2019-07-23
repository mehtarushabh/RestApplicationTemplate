package com.rest.service;

import com.rest.model.User;

import java.util.List;

public interface IUserService{
	
	int createUser(User user);
	
	User findUserbyId(int userId);
	
	List<User> findallUsers();
	
}