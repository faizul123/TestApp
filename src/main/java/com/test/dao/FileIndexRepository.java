package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.dao.beans.FileIndex;

public interface FileIndexRepository extends CrudRepository<FileIndex,String> {

	
	public Iterable<FileIndex> findByisReferenced(boolean isReferenced);
}