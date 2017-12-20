package com.test.resource;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.test.response.beans.DefaultResponse;
import com.test.util.URLDirectory;

public interface DefaultResourceInf {

	@RequestMapping(
				value = URLDirectory.upload,
				method = RequestMethod.POST,
				consumes = MediaType.MULTIPART_FORM_DATA_VALUE
			)
	public DefaultResponse upload( MultipartFile file)
			throws FileNotFoundException,IOException;
	
	@RequestMapping(
			value = URLDirectory.download,
			method = RequestMethod.GET,
			consumes = MediaType.ALL_VALUE,
			produces = MediaType.ALL_VALUE
		)
	public ResponseEntity<Resource> download(String key) throws IOException;
	
	
	@RequestMapping(
				value = URLDirectory.listAllFiles,
				method = RequestMethod.GET,
				consumes = MediaType.ALL_VALUE	
			)
	public DefaultResponse getFiles();
	
	@RequestMapping(value=URLDirectory.removefile,method = RequestMethod.DELETE,consumes=MediaType.ALL_VALUE)
	public DefaultResponse removeFile(String key);
}