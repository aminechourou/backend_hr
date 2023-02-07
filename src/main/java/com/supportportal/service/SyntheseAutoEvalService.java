package com.supportportal.service;

import java.util.List;

import com.supportportal.domain.SyntheseAutoEval;

public interface SyntheseAutoEvalService {
SyntheseAutoEval add(String user);
SyntheseAutoEval getByUser(String user);
SyntheseAutoEval update(String user,String champ,String value);
}
