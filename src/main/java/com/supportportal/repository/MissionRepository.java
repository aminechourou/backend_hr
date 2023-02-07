package com.supportportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.supportportal.domain.Mission;


public interface MissionRepository extends JpaRepository<Mission, Long> {
	@Query(value= "Select * from mission where projet = ?1",nativeQuery = true)
	List<Mission> findPMissionWithProjet(Long idProjet);
	@Query(value= "Select * from mission where user_name = ?1",nativeQuery = true)
	List<Mission> findMissiontWithUser(String userName);
}
