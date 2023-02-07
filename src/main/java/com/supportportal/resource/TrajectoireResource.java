package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.supportportal.domain.Trajectoire;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.TrajectoireService;

@RestController
@RequestMapping(path = {"/trajectoire"})
public class TrajectoireResource {
 TrajectoireService trajectoireService;

public TrajectoireResource(TrajectoireService trajectoireService) {
	super();
	this.trajectoireService = trajectoireService;
}
 
@PostMapping("/add")
public ResponseEntity<?> addTrajectoire(@RequestParam("user") String user)throws UserNotFoundException{
	  Trajectoire s = trajectoireService.add(user);
	  return new ResponseEntity<>(s,OK);
	 
}
@PostMapping("/update")
public ResponseEntity<?> updateTrajectoire(@RequestParam("user") String user,@RequestParam("progression_visee")String progression_visee,
		@RequestParam("progression_tech")String progression_tech, @RequestParam("nextJob_visee") String nextJob_visee,
		@RequestParam("nextJob_tech")String nextJob_tech, @RequestParam("nextRank_visee")String nextRank_visee,
		@RequestParam("nextRank_tech")String nextRank_tech,
		@RequestParam("actions")String actions)throws UserNotFoundException{
	  Trajectoire s = trajectoireService.update(progression_visee, progression_tech, nextJob_visee, nextJob_tech, nextRank_visee, nextRank_tech, actions, user);
	  return new ResponseEntity<>(s,OK);
	 
}

@GetMapping("/getTrajectoire")
public ResponseEntity<?> getTrajectoire(@RequestParam("user") String user)throws UserNotFoundException{
	  Trajectoire s = trajectoireService.get(user);
	  return new ResponseEntity<>(s,OK);
	 
}

}
