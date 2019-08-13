package com.rest.controller;


import com.rest.model.User;
import com.rest.service.IUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MainController{
	
	
	private final IUserService iUserService;
	
	public MainController(IUserService iUserService){
		this.iUserService = iUserService;
	}
	
	
	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public int createUser(@RequestBody User user){
		return iUserService.createUser(user);
	}
	
	
	@RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable int id){
		return iUserService.findUserById(id);
	}
	
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	public List<User> getAllUsers(){
		return iUserService.findAllUsers();
	}
}