package com.rest.utils.impl;

import com.rest.model.DatabaseContext;
import com.rest.utils.IDatabaseUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class PostgresSQLDatabaseUtils implements IDatabaseUtils{
	
	private DatabaseContext DatabaseContext;
	
	PostgresSQLDatabaseUtils(){
		DatabaseContext = new DatabaseContext();
	}
	
	
	public Connection getConnectionFromLocalServer(String dbName,String username,String password){
		Connection connection = null;
		DatabaseContext.setServerIP("localhost");
		DatabaseContext.setPortNumber("5432");
		DatabaseContext.setUserName(username);
		DatabaseContext.setPassword(password);
		DatabaseContext.setDatabaseName(dbName);
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + DatabaseContext.getServerIP() + ":" + DatabaseContext.getPortNumber() + "/" + DatabaseContext.getDatabaseName(),DatabaseContext.getUserName(),DatabaseContext.getPassword()
			);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		
		return connection;
	}
	
	@Override
	public Connection getConnection(DatabaseContext DatabaseContext){
		this.DatabaseContext = DatabaseContext;
		Connection connection = null;
		try{
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:postgresql://" + DatabaseContext.getServerIP() + ":" + DatabaseContext.getPortNumber() + "/" + DatabaseContext.getDatabaseName(),DatabaseContext.getUserName(),DatabaseContext.getPassword()
			);
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
	
}