package com.supportportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supportportal.domain.DomaineCompetence;



public interface DomaineCompetenceRepository extends JpaRepository<DomaineCompetence, Long>{
	@Query(value= "Select * from domainecompetence where user = ?1 and titre = ?2",nativeQuery = true)
	List<DomaineCompetence> findDCWithUser(String userName,String titre);
}
