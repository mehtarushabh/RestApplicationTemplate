package com.rest.utils;

import com.rest.model.DatabaseContext;

import java.sql.Connection;

public interface IDatabaseUtils{
	
	Connection getConnectionFromLocalServer(String dbName,String username,String password);
	
	Connection getConnection(DatabaseContext databaseContext);
	
}
