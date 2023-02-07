package com.supportportal.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supportportal.domain.EvalComite;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.repository.EvalComiteRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.EvalComiteService;

@Service
@Transactional
public class EvalComiteServiceImpl implements EvalComiteService{
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private EvalComiteRepository evalComiteRepository;
	@Autowired
    public EvalComiteServiceImpl(UserRepository userRepository, EvalComiteRepository evalComiteRepository) {
		super();
		this.userRepository = userRepository;
		this.evalComiteRepository = evalComiteRepository;
	}
	@Override
	public EvalComite add(String user) throws UserNotFoundException {
		User u= userRepository.findUserByUsername(user);
		if(u!=null) {
		EvalComite ev = new EvalComite();
		ev.setAppreciation("not submitted");
		ev.setAttenduVSrank("not submitted");
		ev.setContributions("not submitted");
		ev.setMission("not submitted");
		ev.setSynthese_globale("not submitted");
		ev.setUser(u);
		evalComiteRepository.save(ev);
		
		return ev;
		}
		else return null;
	}
	@Override
	public EvalComite update(String mission, String attenduVSrank, String contributions, String appreciation,
			String synthese_globale, String user) throws UserNotFoundException {
		EvalComite ev = evalComiteRepository.findEvalComiteWithUser(user);
		if(ev!=null) {
			ev.setAppreciation(appreciation);
			ev.setAttenduVSrank(attenduVSrank);
			ev.setContributions(contributions);
			ev.setMission(mission);
			ev.setSynthese_globale(synthese_globale);
			evalComiteRepository.save(ev);
			return ev;
		}
		return null;
	}
	@Override
	public EvalComite get(String user) throws UserNotFoundException {
		
		return evalComiteRepository.findEvalComiteWithUser(user);
	}
    
    
}
