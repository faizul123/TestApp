package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.dao.beans.Apps;

public interface AppsRepository extends CrudRepository<Apps, String> {

}
