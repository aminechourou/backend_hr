package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.DomaineCompetence;
import com.supportportal.domain.Mission;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.DomaineCompetenceService;

@RestController
@RequestMapping(path = {"/domainecompetence"})
public class DomaineCompetenceResource {
	private DomaineCompetenceService dcService;

	public DomaineCompetenceResource(DomaineCompetenceService dcService) {
		super();
		this.dcService = dcService;
	}
	@PostMapping("/add")
	public ResponseEntity<?> addDomaineCompetence(@RequestParam("titre") String titre,
	        @RequestParam("soustitre") String sousTitre,
	        @RequestParam("posture") String posture,
	        @RequestParam("autoeval") String autoeval,
	        @RequestParam("user") String user
	        ){
		  DomaineCompetence dc = dcService.addDC(titre, sousTitre, posture, autoeval, user);
		   return new ResponseEntity<>(dc,OK);
		
	}
	@PostMapping("/updateFeedBack/{id}")
	public ResponseEntity<?> updateDomaineCompetenceFeedBack(@PathVariable("id") Long id,
	        @RequestParam("feedback") String feedback
	       
	        ){
		  DomaineCompetence dc = dcService.updateFeedBackManager(id, feedback);
		   return new ResponseEntity<>(dc,OK);
		
	}
	@PostMapping("/updateAutoEval/{id}")
	public ResponseEntity<?> updateDomaineCompetence(@PathVariable("id") Long id,
	        @RequestParam("autoEval") String autoEval
	       
	        ){
		  DomaineCompetence dc = dcService.updateAutoEval(id, autoEval);
		   return new ResponseEntity<>(dc,OK);
		
	}
	@GetMapping("/listwithuser")
	public ResponseEntity<List<DomaineCompetence>> getMissinsByUser(@RequestParam("user") String user,@RequestParam("titre") String titre)throws IOException  {
		
		
	    List<DomaineCompetence> dc = dcService.getDCByUser(user,titre);
	    
	    
	            return new ResponseEntity<>(dc, OK);
	}
	@PostMapping("/createRank")
	public ResponseEntity<List<DomaineCompetence>> createRank(@RequestParam("user") String user)throws IOException  {
		
		
	    List<DomaineCompetence> dc = dcService.createRank(user);
	    
	    
	            return new ResponseEntity<>(dc, OK);
	}
	@PostMapping("/createContribution")
	public ResponseEntity<List<DomaineCompetence>> createContribution(@RequestParam("user") String user)throws IOException  {
		
		
	    List<DomaineCompetence> dc = dcService.createContribution(user);
	    
	    
	            return new ResponseEntity<>(dc, OK);
	}

}
