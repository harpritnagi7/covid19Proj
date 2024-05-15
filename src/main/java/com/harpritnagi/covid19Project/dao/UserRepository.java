package com.harpritnagi.covid19Project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.harpritnagi.covid19Project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	@Query("select u from User u where u.email = :email")
	public User getUserByUserName(@Param("email") String email);
	
	
	//first create getUserByUserName() than write and import @Query choose after that 
	//import @param in getUserByUsername(@param("email") String email) 
	//this was our first setup for spring stater security

}
