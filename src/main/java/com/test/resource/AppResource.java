package com.test.resource;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.request.beans.AppInfo;
import com.test.response.beans.DefaultResponse;

@RestController
@RequestMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppResource implements AppResourceInf {

	@Override
	public DefaultResponse newApp(AppInfo appInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultResponse publish(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultResponse removeApp(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DefaultResponse getApps() {
		// TODO Auto-generated method stub
		return null;
	}

}
