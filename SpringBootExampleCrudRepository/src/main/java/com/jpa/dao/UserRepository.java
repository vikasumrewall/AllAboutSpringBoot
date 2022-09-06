package com.jpa.dao;

import java.util.List;
import java.util.Optional;

import com.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User,Integer> {
	public List<User> findByName(String name);
	public List<User> findByNameOrderByCity(String name);
	public List<User> findByNameAndCity(String name ,String city);
	
	@Query("select u from User u")//HQL
	public List<User> fetchAllHQLusers();
	
	@Query("from User")//HQL
	public List<User> fetchHQLUsersAll();
	
	@Query(value ="select * from user",nativeQuery=true)//Native
	public List<User> fetchUsersAllNativeQuery();
	
	@Query("select u from User u where u.name=:nameP and u.city=:cityP" )//HQL with query where clause
	public List<User> fetchUsersHQlWithWhereClause(@Param("nameP") String name,@Param("cityP") String city);
	
	

	
}
