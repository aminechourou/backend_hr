package com.supportportal.service.impl;

import static com.supportportal.constant.UserImplConstant.NO_USER_FOUND_BY_USERNAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.supportportal.domain.DomaineCompetence;

import com.supportportal.domain.User;
import com.supportportal.repository.DomaineCompetenceRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.DomaineCompetenceService;
import com.supportportal.service.UserService;

@Service
@Transactional
public class DomaineCompetenceServiceImpl implements DomaineCompetenceService{
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private DomaineCompetenceRepository domaineCompetenceRepository;
	private UserRepository userRepository;
	
	
	
	@Autowired
	public DomaineCompetenceServiceImpl(DomaineCompetenceRepository domaineCompetenceRepository,
			UserRepository userRepository) {
		super();
		this.domaineCompetenceRepository = domaineCompetenceRepository;
		this.userRepository = userRepository;
	}

	@Override
	public DomaineCompetence addDC(String titre, String sousTitre, String posture, String autoEval, String userName) {
		
		User user = userRepository.findUserByUsername(userName);
		
        if (user == null) {
            LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + userName);
        }
        else {
        	
        	
        		DomaineCompetence dc = new DomaineCompetence();
            	dc.setAutoEval(autoEval);
            	dc.setPosture(posture);
            	dc.setTitre(titre);
            	dc.setSousTitre(sousTitre);
            	dc.setUser(user);
            	domaineCompetenceRepository.save(dc);
            	return dc;
        	
        	
        	
        }
	}

	@Override
	public DomaineCompetence updateFeedBackManager(Long id, String feedBack) {
		Optional<DomaineCompetence> dc = domaineCompetenceRepository.findById(id);
		if(dc!= null) {
			DomaineCompetence d=dc.get();
			d.setManagerEval(feedBack);
			domaineCompetenceRepository.save(d);
			return d;
          }
		else return null;
	}

	@Override
	public List<DomaineCompetence> getDCByUser(String userName,String titre) {
		
		return domaineCompetenceRepository.findDCWithUser(userName,titre);
	}

	@Override
	public List<DomaineCompetence> createRank(String userName) {
		User u = userRepository.findUserByUsername(userName);
		List<String> list = new ArrayList<String>();
		List<String> titre = new ArrayList<String>();
		listePosture(list, titre);
		
		 if (u == null) {
	            LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
	            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + userName);
	        }
		
		 else{
			    System.out.println("hello"+u.getUsername());
				List<DomaineCompetence> listDc = new ArrayList<DomaineCompetence>();
				for(int i=0;i<15;i++) {
					DomaineCompetence d =new DomaineCompetence();
					d.setAutoEval("not submitted");		
					d.setPosture(list.get(i));
					d.setTitre("rank");
					d.setSousTitre(titre.get(i));
					d.setManagerEval("not submitted");
					d.setUser(u);
					listDc.add(d);
					domaineCompetenceRepository.save(d);
					
				}
				
				
				return listDc;
			
		}
		 
	}
	


	@Override
	public List<DomaineCompetence> createContribution(String userName) {
		User u = userRepository.findUserByUsername(userName);
		List<String> list = new ArrayList<String>();
		list.add("Conna??t les offres de Devoteam et peut les pr??senter de mani??re simple");
		list.add("Participe au d??veloppement de Devoteam ?? travers des actions concr??tes (Cooptation, r??les additionnels, REX, participe aux ??v??nements, ???) ");
	    
		
		 if (u == null) {
	            LOGGER.error(NO_USER_FOUND_BY_USERNAME + userName);
	            throw new UsernameNotFoundException(NO_USER_FOUND_BY_USERNAME + userName);
	        }
		
		 else{
			    System.out.println("hello"+u.getUsername());
				List<DomaineCompetence> listDc = new ArrayList<DomaineCompetence>();
				for(int i=0;i<2;i++) {
					DomaineCompetence d =new DomaineCompetence();
					d.setAutoEval("not submitted");		
					d.setPosture(list.get(i));
					d.setTitre("contributions");
					d.setSousTitre("Implication / Contribution interne");
					d.setManagerEval("not submitted");
					d.setUser(u);
					listDc.add(d);
					domaineCompetenceRepository.save(d);
					
				}
				
				
				return listDc;
			
		}
	}

	@Override
	public DomaineCompetence updateAutoEval(Long id, String autoEval) {
		Optional<DomaineCompetence> dc = domaineCompetenceRepository.findById(id);
		if(dc!= null) {
			DomaineCompetence d=dc.get();
			d.setAutoEval(autoEval);
			domaineCompetenceRepository.save(d);
			return d;
          }
		else return null;
	}
	void listePosture(List<String> list,List<String> listTitre){
		
		list.add("Respecte l???ensemble des process internes et du client"+"(CRA, ???)");
		list.add("Maintient la relation avec Devoteam (r??pond aux mails et sollicitations internes, prend contact spontan??ment avec les contacts principaux : manager, CP, RH, Support..)");
		list.add("Prend en charge l???analyse et la r??alisation des t??ches simples en lien avec son m??tier");
		list.add("Effectue une auto-??valuation de son travail pour assurer le contr??le de qualit?? individuel, l'exhaustivit?? et l'exactitude");
		list.add("Produit des livrables de qualit?? et respecte les d??lais (documentation technique, jalons projets..)");
		list.add("Sait aller chercher l???information, solliciter et alerter si besoin");
		list.add("Sait s???organiser et prioriser ses t??ches/missions");
		list.add("Adopte une attitude professionnelle envers le client");
		list.add("Est identifi?? en tant que consultant Devoteam par le client");
		list.add("Analyse les probl??mes, prend du recul et cherche des solutions dans le respect des process client");
		list.add("Sait transmettre ses connaissances aux autres");
		list.add("Assure une veille technologique ou m??thodologie de mani??re continue et pro-active (fait preuve de curiosit??)");
		list.add("Aligne ses efforts sur les objectifs de l'??quipe / de l'entreprise");
		list.add("Partage de mani??re pro-active des id??es pertinentes, des informations, des opinions et des sentiments");
		list.add("Sait adapter sa posture en fonction de son interlocuteur (Est ?? l?????coute de ses interlocuteurs et ?? un questionnement efficace)");
	
		listTitre.add("Responsabilite");
		listTitre.add("Responsabilite");
		listTitre.add("Autonomie et Qualit?? de travail");
		listTitre.add("Autonomie et Qualit?? de travail");
		listTitre.add("Autonomie et Qualit?? de travail");
		listTitre.add("Autonomie et Qualit?? de travail");
		listTitre.add("Autonomie et Qualit?? de travail");
		listTitre.add("Relation Client");
		listTitre.add("Relation Client");
		listTitre.add("Complexit??");
		listTitre.add("Agilit?? de l'apprentissage");
		listTitre.add("Agilit?? de l'apprentissage");
		listTitre.add("Intelligence Relationelle");
		listTitre.add("Intelligence Relationelle");
		listTitre.add("Intelligence Relationelle");
	   
		
	}
	

}
