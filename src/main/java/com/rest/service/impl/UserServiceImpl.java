package com.rest.service.impl;


import com.rest.dao.IUserDao;
import com.rest.model.User;
import com.rest.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserServiceImpl implements IUserService{
	
	
	private final IUserDao iUserDao;
	
	public UserServiceImpl(IUserDao iUserDao){
		this.iUserDao = iUserDao;
	}
	
	
	@Override
	public int createUser(User user){
		if(! user.getEmail().isBlank() && ! user.getPassword().isBlank()){
			return iUserDao.createUser(user);
		}
		return 0;
	}
	
	
	@Override
	public User findUserById(int userId){
		return iUserDao.getUserById(userId);
	}
	
	
	@Override
	public List<User> findAllUsers(){
		return iUserDao.getAllUsers();
	}
}