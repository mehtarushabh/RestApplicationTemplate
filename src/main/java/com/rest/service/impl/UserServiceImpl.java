package com.rest.service.impl;

import com.rest.dao.IUserDao;
import com.rest.model.User;
import com.rest.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDao iUserDao;
	
	
	@Override
	public int createUser(User user){
		if(! user.getEmail().isBlank() && ! user.getPassword().isBlank()){
			return iUserDao.CreateUser(user);
		}
		return 0;
	}
	
	@Override
	public User findUserbyId(int userId){
		return iUserDao.getUserById(userId);
	}
	
	@Override
	public List<User> findallUsers(){
		return iUserDao.getAllUsers();
	}
	
	
}