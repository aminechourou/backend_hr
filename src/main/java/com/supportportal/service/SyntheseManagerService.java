package com.supportportal.service;


import com.supportportal.domain.Synthese_Manager;

public interface SyntheseManagerService {
	Synthese_Manager add(String user);
	Synthese_Manager getByUser(String user);
	Synthese_Manager update(String user,String champ,String value);
}
