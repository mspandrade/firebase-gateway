package com.mspandrade.firebasegateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mspandrade.firebasegateway.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findOneById(Integer id);
	User findOneByUsername(String username);
	User findOneByEmail(String email);
	
	User findByUsername(String username);
	
}
