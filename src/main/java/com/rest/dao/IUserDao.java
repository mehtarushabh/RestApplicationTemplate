package com.rest.dao;

import com.rest.model.User;

import java.util.List;

public interface IUserDao{
	
	int CreateUser(User user);
	
	User getUserById(int userId);
	
	List<User> getAllUsers();
}
