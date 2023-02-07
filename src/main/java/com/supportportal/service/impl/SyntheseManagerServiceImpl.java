package com.supportportal.service.impl;

import static com.supportportal.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supportportal.domain.Synthese_Manager;
import com.supportportal.domain.User;
import com.supportportal.repository.SyntheseManagerRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.SyntheseManagerService;

@Service
@Transactional
public class SyntheseManagerServiceImpl implements SyntheseManagerService{
    
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private UserRepository userRepository;
	private SyntheseManagerRepository syntheseManagerRepository;
	
	
	
	
	@Autowired
	public SyntheseManagerServiceImpl( UserRepository userRepository,
			SyntheseManagerRepository syntheseManagerRepository) {
	
		this.userRepository = userRepository;
		this.syntheseManagerRepository = syntheseManagerRepository;
	}

	@Override
	public Synthese_Manager add(String user) {
		
		User u = userRepository.findUserByUsername(user);
        if (u == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + user);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + user);
        }
        else {
        	Synthese_Manager s =new Synthese_Manager();
        	s.setPerformance("not submitted");
        	s.setNotePerformance("not submitted");
        	s.setContribution("not submitted");
        	s.setNoteContribution("not submitted");
        	s.setRank("not submitted");
        	s.setNoteRank("not submitted");
        	s.setUser(u);
        	syntheseManagerRepository.save(s);
        	return s;
        }
		

	}

	@Override
	public Synthese_Manager getByUser(String user) {
		
		return syntheseManagerRepository.findSyntheseMangerByUser(user);
	}

	@Override
	public Synthese_Manager update(String user, String champ, String value) {
		Synthese_Manager s = syntheseManagerRepository.findSyntheseMangerByUser(user);
		if(s!=null) {
			switch (champ) {
			case "performance": s.setPerformance(value);
				break;
			case "notePerformance": s.setNotePerformance(value);
			    break;
			case "contribution": s.setContribution(value);
			break;
			case "noteContribution": s.setNoteContribution(value);
			break;
			case "rank": s.setRank(value);
			break;
			case "noteRank": s.setNoteRank(value);
			break;

			default:
				break;
			}
			syntheseManagerRepository.save(s);
			return s;
		}
		else return null;
	}

}
