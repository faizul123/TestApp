package com.test.resource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.test.config.AppConstants;
import com.test.response.beans.DefaultResponse;
import com.test.service.FileInfo;
import com.test.service.StorageService;

@RestController
@RequestMapping(
		consumes=MediaType.APPLICATION_JSON_UTF8_VALUE,
		produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class DefaultResource implements DefaultResourceInf {

	Logger logger = Logger.getLogger("");
		
	@Autowired
	StorageService storageService;
	
	@Override
	public DefaultResponse upload(@RequestParam("file")MultipartFile data) throws FileNotFoundException,IOException {
		Map<String,Object> map = new HashMap<String,Object>();
		FileInfo fileInfo = storageService.save(new FileInfo(data,AppConstants.UPLOAD_PATH)).get();
		map.put("fileInfo", fileInfo);
		map.put("message", "Successfully uploaded");
		return new DefaultResponse(200, map);
	}

	@Override
	public ResponseEntity<Resource> download(@RequestParam(name="key")String key) throws IOException {
		Optional<FileInfo> optional = storageService.get(key);
		if(optional.isPresent()){
		FileInfo info = optional.get();
		ByteArrayResource resource = new ByteArrayResource(info.getBytes());
		return ResponseEntity.ok()
				.header("Content-Type", info.getContentType())
				.header("Content-Disposition", "attachment; filename=" + info.getName())
				.body(resource);
		}else{
			
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	public DefaultResponse getFiles() {
		Map<String,Object> map = new HashMap<String,Object>();
		List<FileInfo> files = storageService.getFiles(false);
		map.put("files",files);
		return new DefaultResponse(200, map);
	}

	@Override
	public DefaultResponse removeFile(@PathVariable(name="key") String key) {
		Map<String,Object> map = new HashMap<String,Object>();
		int status = 200;
		if(storageService.remove(key)){
			map.put("message", "Successfully removed!");
		}else{
			status = 400;
			map.put("message", "Couldn't remove a file");; 
		}
		return new DefaultResponse(status,map);
	}

}
