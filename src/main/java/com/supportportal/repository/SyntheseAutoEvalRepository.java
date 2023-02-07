package com.supportportal.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.supportportal.domain.SyntheseAutoEval;

public interface SyntheseAutoEvalRepository extends JpaRepository<SyntheseAutoEval, Long> {
	@Query(value= "Select * from synthese_auto_eval where user_name = ?1",nativeQuery = true)
	SyntheseAutoEval findSyntheseAutoEvalByUser(String user);
}
