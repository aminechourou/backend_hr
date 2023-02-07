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

import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.ProjetService;

@Service
@Transactional
public class ProjetServiceImpl implements ProjetService {
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
    private UserRepository userRepository;
    private ProjetRepository projetRepository;
    
    @Autowired
	public ProjetServiceImpl( UserRepository userRepository, ProjetRepository projetRepository) {
		

		this.userRepository = userRepository;
		this.projetRepository = projetRepository;
	}

	@Override
	public Projet addProject(String titre, String description, String etat, String duree, String client, String chef) {
		User user = userRepository.findUserByUsername(chef);
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + chef);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + chef);
        }
        else {
        	Projet pr = projetRepository.findProjectWithTitle(titre);
        	if(pr == null) {
        		Projet p = new Projet();
            	p.setTitre(titre);
            	p.setDescription(description);
            	p.setDure(duree);
            	p.setEtat(etat);
            	p.setClient(client);
            	p.setChef(user);
            	projetRepository.save(p);
            	return p;
        	}
        	else return null;
        	
        }
		
	}

	@Override
	public Projet updateProject(Long id, String titre, String description, String etat, String duree,
			String client, User chef) {
		Optional<Projet> projet = projetRepository.findById(id);
	
			projet.get().setTitre(titre);
			projet.get().setDescription(description);
			projet.get().setEtat(etat);
			projet.get().setDure(duree);
			projet.get().setClient(client);
			projet.get().setChef(chef);
			return projet.get();
		
		
	}

	@Override
	public void deleteProject(String titre) {
		Projet p = projetRepository.findProjectWithTitle(titre);
		projetRepository.deleteById(p.getId());
		
	}

	@Override
	public List<Projet> findProjectByClient(String client) {
		
		return projetRepository.findProjectWithClient(client);
	}

	@Override
	public List<Projet> getProjects() {
		
		return projetRepository.findAll();
	}

	@Override
	public Projet getProject(String titre) {
		
		return projetRepository.findProjectWithTitle(titre);
	}
	
	

}
