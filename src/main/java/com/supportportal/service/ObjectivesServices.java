package com.supportportal.service;

import java.util.List;

import com.supportportal.domain.Objectives;
import com.supportportal.exception.domain.UserNotFoundException;

public interface ObjectivesServices {
Objectives add(String description,String etat, String userName)throws UserNotFoundException;
void delete(Long id);
Objectives updateEtat(Long id);
Objectives updateDescription(Long id,String description);
List<Objectives> getObjectiveByUser(String userName);
}
