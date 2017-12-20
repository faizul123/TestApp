package com.test.request.beans;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignupRequest {

	private String username;
	
	private String password;
	
	private String name;
	
	@JsonCreator
	public SignupRequest(@JsonProperty("username") String uname,@JsonProperty("password") String pwd,@JsonProperty("name") String name){
		username = uname;
		password = pwd;
		this.name = name;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
}
