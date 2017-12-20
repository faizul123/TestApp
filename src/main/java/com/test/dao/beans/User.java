package com.test.dao.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity()
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String username;
	
	private String password;
	
	protected User(){}
	
	public User(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
}
