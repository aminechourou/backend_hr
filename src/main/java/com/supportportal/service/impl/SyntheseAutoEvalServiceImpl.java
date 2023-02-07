package com.supportportal.service.impl;

import static com.supportportal.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supportportal.domain.SyntheseAutoEval;
import com.supportportal.domain.User;
import com.supportportal.repository.SyntheseAutoEvalRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.SyntheseAutoEvalService;
@Service
@Transactional
public class SyntheseAutoEvalServiceImpl implements SyntheseAutoEvalService{
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private UserRepository userRepository;
	private SyntheseAutoEvalRepository syntheseRepository;
	@Autowired
	public SyntheseAutoEvalServiceImpl( UserRepository userRepository,
			SyntheseAutoEvalRepository syntheseRepository) {
		super();
		
		this.userRepository = userRepository;
		this.syntheseRepository = syntheseRepository;
	}

	@Override
	public SyntheseAutoEval add(String user) {
		User u = userRepository.findUserByUsername(user);
        if (u == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + user);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + user);
        }
        else {
        	SyntheseAutoEval s = new SyntheseAutoEval();
        	s.setAttentes("not submitted");
        	s.setAxesAmeliorations("not submitted");
        	s.setEnseignements("not submitted");
        	s.setPtsForts("not submitted");
        	s.setSatisfaction("not submitted");
        	s.setPtsFortsManger("not submitted");
        	s.setAxesAmeliorationsManager("not submitted");
        	s.setEnseignementsManager("not submitted");
        	s.setUser(u);
        	syntheseRepository.save(s);
        	return s;
        }
		
	}



	@Override
	public SyntheseAutoEval getByUser(String user) {
		
		return syntheseRepository.findSyntheseAutoEvalByUser(user);
	}

	@Override
	public SyntheseAutoEval update(String user,String champ,String value) {
		SyntheseAutoEval s =syntheseRepository.findSyntheseAutoEvalByUser(user);
		if(s!=null) {
			switch (champ) {
			case "ptsForts":
				s.setPtsForts(value);
				break;
			case "ptsFortsManger":
				s.setPtsFortsManger(value);
				break;
			case "enseignement":
				s.setEnseignements(value);
				break;
			case "enseignementManger":
				s.setEnseignementsManager(value);
				break;
			case "axes":
				s.setAxesAmeliorations(value);
				break;
			case "axesManager":
				s.setAxesAmeliorationsManager(value);
				break;
			case "satisfaction":
				s.setSatisfaction(value);
				break;
			case "attentes":
				s.setAttentes(value);
				break;	

			default:
				break;
			}
			syntheseRepository.save(s);
			return s;
		}
		return null;
	}

}
