package com.supportportal.service;

import java.util.List;

import com.supportportal.domain.DomaineCompetence;

public interface DomaineCompetenceService {
DomaineCompetence addDC(String titre,String sousTitre,String posture,String autoEval,String userName);
DomaineCompetence updateFeedBackManager(Long id,String feedBack);
List<DomaineCompetence> getDCByUser(String userName,String titre);
List<DomaineCompetence> createRank(String userName);
List<DomaineCompetence> createContribution(String userName);
DomaineCompetence updateAutoEval(Long id,String feedBack);
}
