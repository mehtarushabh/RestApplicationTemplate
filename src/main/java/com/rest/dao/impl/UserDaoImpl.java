package com.rest.dao.impl;

import com.rest.dao.IUserDao;
import com.rest.model.User;
import com.rest.utils.IDatabaseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements IUserDao{
	
	@Autowired
	private IDatabaseUtils IDatabaseUtils;
	
	
	public UserDaoImpl(IDatabaseUtils IDatabaseUtils){
		this.IDatabaseUtils = IDatabaseUtils;
	}
	
	
	@Override
	public int CreateUser(User user){
		Connection connection = IDatabaseUtils.getConnectionFromLocalServer("rest","postgres","admin");
		ResultSet rs;
		String sql = "INSERT INTO users(\"firstName\", \"lastName\", email, password, dob)" + "VALUES ( ?, ?, ?, ?, ?);";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1,user.getFirstName());
			preparedStatement.setString(2,user.getLastName());
			preparedStatement.setString(3,user.getEmail());
			preparedStatement.setString(4,user.getPassword());
			preparedStatement.setDate(5,Date.valueOf(user.getDob()));
			preparedStatement.execute();
			connection.close();
			rs = preparedStatement.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public User getUserById(int userId){
		Connection connection = IDatabaseUtils.getConnectionFromLocalServer("rest","postgres","admin");
		ResultSet rs;
		String sql = "SELECT * FROM users WHERE userId = ?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,userId);
			rs = preparedStatement.executeQuery();
			connection.close();
			while(rs.next()){
				return populateUserFromResultSetInstance(rs);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public User populateUserFromResultSetInstance(ResultSet rs){
		User user = new User();
		try{
			user.setUserId(rs.getInt(1));
			user.setFirstName(rs.getString(2));
			user.setLastName(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setPassword(rs.getString(5));
			user.setDob(rs.getDate(6).toLocalDate());
		}catch(SQLException e){
			e.printStackTrace();
		}
		return user;
	}
	
	
	@Override
	public List<User> getAllUsers(){
		Connection connection = IDatabaseUtils.getConnectionFromLocalServer("rest","postgres","admin");
		ResultSet rs;
		String sql = "SELECT * FROM users";
		List<User> allUsers = new ArrayList<>();
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while(rs.next()){
				allUsers.add(populateUserFromResultSetInstance(rs));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return allUsers;
	}
}