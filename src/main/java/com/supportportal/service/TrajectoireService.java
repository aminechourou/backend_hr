package com.supportportal.service;

import com.supportportal.domain.Trajectoire;
import com.supportportal.exception.domain.UserNotFoundException;

public interface TrajectoireService {

	
	Trajectoire add(String user)throws UserNotFoundException;
	Trajectoire get(String user)throws UserNotFoundException;
	Trajectoire update(String progression_visee,String progression_tech,String nextJob_visee,String nextJob_tech,String nextRank_visee,String nextRank_tech,String actions,String user)throws UserNotFoundException;
	
}
