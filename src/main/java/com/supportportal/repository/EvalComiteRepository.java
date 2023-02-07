package com.supportportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.supportportal.domain.EvalComite;


public interface EvalComiteRepository extends JpaRepository<EvalComite, Long>{
	@Query(value= "Select * from eval_comite where user_name = ?1",nativeQuery = true)
	EvalComite findEvalComiteWithUser(String userName);
}
