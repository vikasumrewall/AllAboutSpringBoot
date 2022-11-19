package com.api.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	//@Query(Select u from user u where u.email = :email)
	//User getUserByName(@Param("email") String email);

	User findByUsername(String username);

}

