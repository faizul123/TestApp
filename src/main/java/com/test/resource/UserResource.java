package com.test.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.dao.UserRepository;
import com.test.dao.beans.User;
import com.test.request.beans.UserInfo;

@RestController()
@RequestMapping(consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserResource {

	@Autowired
	UserRepository userRepo;
		
	@RequestMapping(
			value="/user",
			method = RequestMethod.POST
			)
	public ResponseEntity<Map<String,Object>> createUser(@RequestBody UserInfo userInfo){
		Map<String,Object> map = new HashMap<String,Object>();
		User user = new User(userInfo.getUsername(),userInfo.getPassword());
		userRepo.save(user);
		map.put("user", user);
		
		return new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
	}
	
	
}
