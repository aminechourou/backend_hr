package com.supportportal.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.domain.Trajectoire;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.repository.TrajectoireRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.TrajectoireService;

@Service
@Transactional
public class TrajectoireServiceImpl implements TrajectoireService{
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private TrajectoireRepository trajectoireRepository;
	
    @Autowired
    public TrajectoireServiceImpl(UserRepository userRepository, TrajectoireRepository trajectoireRepository) {
		super();
		this.userRepository = userRepository;
		this.trajectoireRepository = trajectoireRepository;
	}

	@Override
	public Trajectoire add(String user) throws UserNotFoundException {
		User u= userRepository.findUserByUsername(user);
		if(u!=null) {
			Trajectoire t = new Trajectoire();
			t.setActions("not submitted");
			t.setNextJob_tech("not submitted");
			t.setNextJob_visee("not submitted");
			t.setNextRank_tech("not submitted");
			t.setNextRank_visee("not submitted");
			t.setProgression_tech("not submitted");
			t.setProgression_visee("not submitted");
			t.setUser(u);
			trajectoireRepository.save(t);
			return t;
		}
		else return null;
	}

	@Override
	public Trajectoire get(String user) throws UserNotFoundException {
		
		return trajectoireRepository.findTrajectoireWithUser(user);
	}

	@Override
	public Trajectoire update(String progression_visee, String progression_tech, String nextJob_visee,
			String nextJob_tech, String nextRank_visee, String nextRank_tech, String actions, String user)
			throws UserNotFoundException {
		
		Trajectoire t = trajectoireRepository.findTrajectoireWithUser(user);
		if(t!=null) {
			
			t.setActions(actions);
			t.setNextJob_tech(nextJob_tech);
			t.setNextJob_visee(nextJob_visee);
			t.setNextRank_tech(nextRank_tech);
			t.setNextRank_visee(nextRank_visee);
			t.setProgression_tech(progression_tech);
			t.setProgression_visee(progression_visee);
			trajectoireRepository.save(t);
			return t;
		}
		else return null;
	}
    
    
}
