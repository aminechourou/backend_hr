package com.supportportal.service;

import com.supportportal.domain.EvalComite;
import com.supportportal.exception.domain.UserNotFoundException;

public interface EvalComiteService {
 EvalComite add(String user) throws UserNotFoundException;
 EvalComite update(String mission,String attenduVSrank,String contributions,String appreciation,String synthese_globale,String user) throws UserNotFoundException;
 EvalComite get(String user) throws UserNotFoundException;
}
