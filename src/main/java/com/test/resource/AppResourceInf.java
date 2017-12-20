package com.test.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.request.beans.AppInfo;
import com.test.response.beans.DefaultResponse;
import com.test.util.URLDirectory;

public interface AppResourceInf {

	@RequestMapping(
			value = URLDirectory.newApp,
			method = RequestMethod.POST 
			)
	public DefaultResponse newApp(AppInfo appInfo);
	
	
	
	@RequestMapping(
				value = URLDirectory.publish,
				method = RequestMethod.GET
			)	
	public DefaultResponse publish(String id);
	
	
	
	@RequestMapping(
				value = URLDirectory.removeApp,
				method = RequestMethod.DELETE
			)	
	public DefaultResponse removeApp(String id);
	
	
	
	@RequestMapping(
				value = URLDirectory.listAllAppsInfo,
				method = RequestMethod.GET
			)
	public DefaultResponse getApps();
}
