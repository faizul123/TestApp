package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.dao.beans.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
