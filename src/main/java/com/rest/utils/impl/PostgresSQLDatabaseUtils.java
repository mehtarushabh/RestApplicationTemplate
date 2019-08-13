package com.rest.utils.impl;


import com.rest.model.DatabaseContext;
import com.rest.utils.IDatabaseUtils;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Component
public class PostgresSQLDatabaseUtils implements IDatabaseUtils{
	
	
	public Connection getConnectionFromLocalServer(String dbName,String username,String password){
		DatabaseContext databaseContext = new DatabaseContext();
		databaseContext.setServerIP("localhost");
		databaseContext.setPortNumber("5432");
		databaseContext.setUserName(username);
		databaseContext.setPassword(password);
		databaseContext.setDatabaseName(dbName);
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://" + databaseContext.getServerIP() + ":" + databaseContext.getPortNumber() + "/" + databaseContext.getDatabaseName(),databaseContext.getUserName(),databaseContext.getPassword());
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public Connection getConnection(DatabaseContext databaseContext){
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://" + databaseContext.getServerIP() + ":" + databaseContext.getPortNumber() + "/" + databaseContext.getDatabaseName(),databaseContext.getUserName(),databaseContext.getPassword());
		}catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return null;
	}
}