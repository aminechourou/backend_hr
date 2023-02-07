package com.supportportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.supportportal.domain.Synthese_Manager;

public interface SyntheseManagerRepository extends JpaRepository<Synthese_Manager, Long> {
	@Query(value= "Select * from synthese_manager where user_name = ?1",nativeQuery = true)
	Synthese_Manager findSyntheseMangerByUser(String user);

}
