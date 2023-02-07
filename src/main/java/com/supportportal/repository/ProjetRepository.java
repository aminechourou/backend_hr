package com.supportportal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supportportal.domain.Projet;


public interface ProjetRepository extends JpaRepository<Projet, Long> {
    
	@Query(value= "Select * from projet where client = ?1",nativeQuery = true)
	List<Projet> findProjectWithClient(String client);
	@Query(value= "Select * from projet where titre = ?1",nativeQuery = true)
	Projet findProjectWithTitle(String titre);
	

}
