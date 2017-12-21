package com.test.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.test.dao.beans.FileIndex;

public interface FileIndexRepository extends CrudRepository<FileIndex,String> {

	
	public List<FileIndex> findByisReferenced(boolean isReferenced);
}