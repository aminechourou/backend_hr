package com.supportportal.service;

import java.util.List;

import com.supportportal.domain.Mission;

public interface MissionService {
Mission addMission(String realisation, String userName,Long projet);
Mission updateMissionAutoEval(Long idMission,String AutoEval);
Mission updateMissionFeedBackManager(Long idMission,String feedback);
Mission updateEtat(Long idMission);
Mission updateRealisation(Long idMission, String realisation);
void deleteMission(Long idMission);
List<Mission> getMissionsByProject(Long idProjet);
List<Mission> getMissionByUser(String userName);

}
