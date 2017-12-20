package com.test.response.beans;

public class DefaultResponse {

	private int code;
	
	private Object data;
	
	public DefaultResponse(int code,Object data){
		this.code = code;
		this.data = data;
	}
	
	public Object getData(){return data;}
	
	public int getCode(){return code;}
	
}
