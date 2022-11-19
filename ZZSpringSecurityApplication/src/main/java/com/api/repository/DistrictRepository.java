package com.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.api.model.District;
import com.api.model.State;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{
	
	@Query (value = "select obj from District obj where state.id=:id" )
	List<District> findDistrictLstByStateId(@Param("id") Integer id);
	
	List<District> findAllByState(Optional<State> optionlSate);

}
