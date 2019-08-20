package com.globalsociety.global.login.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.globalsociety.global.login.bean.Login;

public interface LoginRepositary extends CrudRepository<Login, Long> {

	//public Optional<Login> findByusername(String username);
	
	@Query("SELECT l FROM Login l  where l.username= :username")
	public Login findByusername(@Param("username") String username);
}
