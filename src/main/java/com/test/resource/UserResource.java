package com.test.resource;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.request.beans.SignupRequest;

@RestController()
@RequestMapping(
		consumes=MediaType.APPLICATION_JSON_VALUE,
		produces=MediaType.APPLICATION_JSON_VALUE
		)
public class UserResource {

	
	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public ResponseEntity<Map<String,Object>> signup(@RequestBody SignupRequest request){
		return new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
	}
	
}
