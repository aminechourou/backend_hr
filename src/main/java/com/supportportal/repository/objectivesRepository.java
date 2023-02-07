package com.supportportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.supportportal.domain.Objectives;

public interface objectivesRepository extends JpaRepository<Objectives, Long>{
	@Query(value= "Select * from objective where user_name = ?1",nativeQuery = true)
	List<Objectives> findObjectibvesWithUser(String user);
}
