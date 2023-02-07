package com.supportportal.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.supportportal.domain.Trajectoire;

public interface TrajectoireRepository extends JpaRepository<Trajectoire, Long>{
	@Query(value= "Select * from trajectoire where user_name = ?1",nativeQuery = true)
	Trajectoire findTrajectoireWithUser(String userName);
}
