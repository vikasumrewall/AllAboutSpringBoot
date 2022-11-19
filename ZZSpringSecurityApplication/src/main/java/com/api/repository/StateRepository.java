package com.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.model.State;
import com.api.model.User;

@Repository
public interface StateRepository extends JpaRepository<State, Integer>{
	
	@Query (value = " select obj from State obj" )
	List<State> findAllState();
	
	

}
