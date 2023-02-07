package com.supportportal.service.impl;

import static com.supportportal.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supportportal.domain.Mission;
import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.repository.MissionRepository;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.MissionService;


@Service
@Transactional
public class MissionServiceImpl implements MissionService{
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private ProjetRepository projetRepository;
    private MissionRepository missionRepository;
    @Autowired
	public MissionServiceImpl(UserRepository userRepository, ProjetRepository projetRepository,MissionRepository missionRepository) {
		
		this.userRepository = userRepository;
		this.projetRepository = projetRepository;
		this.missionRepository= missionRepository;
	}

	@Override
	public Mission addMission(String realisation, String userName, Long projet) {
		User user = userRepository.findUserByUsername(userName);
		Optional<Projet> p = projetRepository.findById(projet);
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + userName);
        }
        else {
        	
        	
        		Mission m = new Mission();
            	m.setRealisation(realisation);
            	m.setProjet(p.get());
            	m.setUser(user);
            	m.setEtat("doing");
            	missionRepository.save(m);
            	return m;
        	
        	
        	
        }
	}

	@Override
	public Mission updateMissionAutoEval(Long idMission, String AutoEval) {
		Optional<Mission> m = missionRepository.findById(idMission);
		if(m!=null) {
			Mission mission =m.get();
			mission.setAutoEval(AutoEval);
			missionRepository.save(mission);
			return mission;
		}
		else return null;
	}

	@Override
	public Mission updateMissionFeedBackManager(Long idMission, String feedback) {
		Optional<Mission> m = missionRepository.findById(idMission);
		if(m!=null) {
			Mission mission =m.get();
			mission.setFeedBackManager(feedback);
			missionRepository.save(mission);
			return mission;
		}
		else return null;
	}

	@Override
	public void deleteMission(Long idMission) {
		missionRepository.deleteById(idMission);
		
	}

	@Override
	public List<Mission> getMissionsByProject(Long idProjet) {
		
		return missionRepository.findPMissionWithProjet(idProjet);
	}

	@Override
	public List<Mission> getMissionByUser(String userName) {
		
		return missionRepository.findMissiontWithUser(userName);
	}

	@Override
	public Mission updateEtat(Long idMission) {
		Optional<Mission> m = missionRepository.findById(idMission);
		if(m!=null) {
			Mission mission =m.get();
			mission.setEtat("done");
			missionRepository.save(mission);
			return mission;
		}
		else return null;
	}

	@Override
	public Mission updateRealisation(Long idMission, String realisation) {
		Optional<Mission> m = missionRepository.findById(idMission);
		if(m!=null) {
			Mission mission =m.get();
			mission.setRealisation(realisation);;
			missionRepository.save(mission);
			return mission;
		}
		else return null;
	}

}
