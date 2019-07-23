package com.rest.model;

public class DatabaseContext{
	
	private String serverIP = null;
	private String portNumber = null;
	private String userName = null;
	private String password = null;
	private String databaseName = null;
	
	public String getServerIP(){
		return serverIP;
	}
	
	public void setServerIP(String serverIP){
		this.serverIP = serverIP;
	}
	
	public String getPortNumber(){
		return portNumber;
	}
	
	public void setPortNumber(String portNumber){
		this.portNumber = portNumber;
	}
	
	public String getUserName(){
		return userName;
	}
	
	public void setUserName(String userName){
		this.userName = userName;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getDatabaseName(){
		return databaseName;
	}
	
	public void setDatabaseName(String databaseName){
		this.databaseName = databaseName;
	}
}
