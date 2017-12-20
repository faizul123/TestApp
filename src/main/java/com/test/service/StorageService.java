package com.test.service;

import java.io.IOException;
import java.util.List;

public interface StorageService {

	FileInfo save(FileInfo fileInfo)
			throws IOException;
	
	FileInfo get(String file) throws IOException;
	
	boolean remove(String fileName);
	
	List<FileInfo> getFiles(boolean isUnreferenced);
	
}
 