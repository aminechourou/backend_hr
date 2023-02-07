package com.supportportal.service.impl;

import static com.supportportal.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supportportal.domain.Objectives;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.repository.UserRepository;
import com.supportportal.repository.objectivesRepository;
import com.supportportal.service.ObjectivesServices;


@Service
@Transactional
public class ObjectivesServicesImpl implements ObjectivesServices {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private objectivesRepository objectivesRepository;
    
    @Autowired
    public ObjectivesServicesImpl(UserRepository userRepository,
			com.supportportal.repository.objectivesRepository objectivesRepository) {
		super();
		this.userRepository = userRepository;
		this.objectivesRepository = objectivesRepository;
	}

	@Override
	public Objectives add(String description, String etat, String userName) throws UserNotFoundException {
		User u  =userRepository.findUserByUsername(userName);
		Objectives ob = new Objectives();
		if(u!=null) {
			ob.setDescription(description);
			ob.setEtat(etat);
			ob.setUser(u);
			objectivesRepository.save(ob);
			return ob;
		}
		else {
			 LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
	            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + userName);
		}
	}

	

	@Override
	public void delete(Long id) {
		objectivesRepository.deleteById(id);
		
	}

	@Override
	public Objectives updateEtat(Long id) {
		Objectives ob = objectivesRepository.getOne(id);
		if(ob!=null) {
			ob.setEtat("approved");
			objectivesRepository.save(ob);
			return ob;
		}
		else return null;
	}

	@Override
	public Objectives updateDescription(Long id, String description) {
		Objectives ob = objectivesRepository.findById(id).get();
		if(ob!=null) {
			ob.setDescription(description);
			objectivesRepository.save(ob);
			return ob;
		}
		else return null;
	}

	@Override
	public List<Objectives> getObjectiveByUser(String userName) {
		List<Objectives> list = objectivesRepository.findObjectibvesWithUser(userName);
		return list;
	}

}
