package com.test.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.dao.FileIndexRepository;
import com.test.dao.beans.FileIndex;

@Service
public class StorageServiceImpl implements StorageService {

	private FileIndexRepository fileRepo;
	
	public StorageServiceImpl(FileIndexRepository fileRepo) {
		this.fileRepo = fileRepo;
	}
	
	@Override
	public Optional<FileInfo> save(FileInfo fileInfo) throws IOException {		
		File file = new File(fileInfo.getDestPath());
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(fileInfo.getBytes());
		fos.close();
		fileRepo.save(new FileIndex(fileInfo));
		fileInfo.setDownloadLink(fileInfo.getId());
		return Optional.of(fileInfo);
	}
	
	@Override
	public Optional<FileInfo> get(String fileName) throws IOException {
		
		Optional<FileIndex> optional = Optional.ofNullable(fileRepo.findOne(fileName));
		if(optional.isPresent()){
			
			fileName = optional.get().getDestPath();
			File file = new File(fileName);		
			Path path = Paths.get(file.getAbsolutePath());		
			FileInfo fileInfo = new FileInfo(optional.get());
			fileInfo.setBytes(Files.readAllBytes(path));
			return Optional.of(fileInfo);
		}else{
			return Optional.empty();
		}
	}

	@Override
	public boolean remove(String fileName) {
		fileRepo.delete(fileName);
		return new File(fileName).delete();
	}

	@Override
	public List<FileInfo> getFiles(boolean isUnreferenced) {
		List<FileInfo> files = fileRepo.findByisReferenced(false).stream()
				.map(
						(FileIndex f) -> {							
							return new FileInfo(f);
							}
						)
				.collect(Collectors.toList());
				
		return files;
	}
	
}
