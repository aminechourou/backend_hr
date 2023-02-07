package com.supportportal.service;

import java.util.List;

import com.supportportal.domain.Projet;
import com.supportportal.domain.User;

public interface ProjetService {
  Projet addProject(String titre,String description,String etat,String duree,String client,String chef);
  
  Projet  updateProject(Long id,String titre,String description,String etat,String duree,String client,User chef); 
  void deleteProject(String titre);
  List<Projet> findProjectByClient(String client);
  List<Projet> getProjects();
  Projet getProject(String titre);
  
}
