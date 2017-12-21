package com.test.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface StorageService {

	Optional<FileInfo> save(FileInfo fileInfo)
			throws IOException;
	
	Optional<FileInfo> get(String file) throws IOException;
	
	boolean remove(String fileName);
	
	List<FileInfo> getFiles(boolean isUnreferenced);
	
}
 