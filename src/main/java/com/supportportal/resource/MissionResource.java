package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.HttpResponse;
import com.supportportal.domain.Mission;

import com.supportportal.service.MissionService;

@RestController
@RequestMapping(path = {"/mission"})
public class MissionResource {
	
		
		private MissionService missionService;
		public static final String PROJET_DELETED_SUCCESSFULLY = "mission deleted successfully";
		public MissionResource(MissionService missionService) {
			super();
			
			this.missionService = missionService;
		}
		
		@PostMapping("/add/{id}")
		public ResponseEntity<?> addMission(@RequestParam("realisation") String realisation,
		        @RequestParam("user") String user,
		        @PathVariable("id") Long idProjet
		        ){
			  Mission mission = missionService.addMission(realisation, user, idProjet);
			   return new ResponseEntity<>(mission,OK);
			
		}
		
		@PostMapping("/updateautoeval/{id}")
		public ResponseEntity<?> updateAutoEvalMission(@PathVariable("id") Long idMission,
		        @RequestParam("autoeval") String autoEval
		        
		        ){
			  Mission mission = missionService.updateMissionAutoEval(idMission, autoEval);
			   return new ResponseEntity<>(mission,OK);
			
		}
		@PostMapping("/updatefeedback/{id}")
		public ResponseEntity<?> updateFeedBackMission(@PathVariable("id") Long idMission,
		        @RequestParam("feedback") String feedBack
		        
		        ){
			  Mission mission = missionService.updateMissionFeedBackManager(idMission, feedBack);
			   return new ResponseEntity<>(mission,OK);
			
		}
		@PostMapping("/updaterealisation/{id}")
		public ResponseEntity<?> updateRealisationMission(@PathVariable("id") Long idMission,
		        @RequestParam("realisation") String realisation
		        
		        ){
			  Mission mission = missionService.updateRealisation(idMission, realisation);
			   return new ResponseEntity<>(mission,OK);
			
		}
		@PostMapping("/updateEtat/{id}")
		public ResponseEntity<?> updateEtat(@PathVariable("id") Long idMission
		        ){
			  Mission mission = missionService.updateEtat(idMission);
			   return new ResponseEntity<>(mission,OK);
			
		}
		@DeleteMapping("/delete/{id}")
		@PreAuthorize("hasAnyAuthority('user:delete')")
		public ResponseEntity<HttpResponse> deleteUser(@PathVariable("id") Long id) throws IOException {
		    missionService.deleteMission(id);
		    return response(OK, PROJET_DELETED_SUCCESSFULLY);
		}
		@GetMapping("/listwithuser/{user}")
		public ResponseEntity<List<Mission>> getMissinsByUser(@PathVariable("user") String user)throws IOException  {
			
			
		    List<Mission> mission = missionService.getMissionByUser(user);
		    
		    
		            return new ResponseEntity<>(mission, OK);
		}
		@GetMapping("/listwithproject/{id}")
		public ResponseEntity<List<Mission>> getMissionsByProject(@PathVariable("id") Long id)throws IOException  {
			
			
		    List<Mission> missions = missionService.getMissionsByProject(id); 
		    
		    
		            return new ResponseEntity<>(missions, OK);
		}
		
		private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
		    return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
		            message), httpStatus);
		}
		

}