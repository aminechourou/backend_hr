package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.SyntheseAutoEval;
import com.supportportal.domain.Synthese_Manager;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.SyntheseManagerService;

@RestController
@RequestMapping(path = {"/managerEval"})
public class SyntheseManagerResource {
SyntheseManagerService syntheseManagerService;

public SyntheseManagerResource(SyntheseManagerService syntheseManagerService) {
	super();
	this.syntheseManagerService = syntheseManagerService;
}
@PostMapping("/add")
public ResponseEntity<?> addAutoEval(@RequestParam("user") String user)throws UserNotFoundException{
	  Synthese_Manager s = syntheseManagerService.add(user);
	  return new ResponseEntity<>(s,OK);
	 
}

@PostMapping("/update")
public ResponseEntity<?> updateAutoEval(@RequestParam("user") String user,@RequestParam("champ") String champ,@RequestParam("value") String value)throws UserNotFoundException{
	Synthese_Manager s = syntheseManagerService.update(user, champ, value);
	  return new ResponseEntity<>(s,OK);
	 
}
@GetMapping("/getManagerEvalByUser")
public ResponseEntity<?> getAutoEval(@RequestParam("user") String user)throws UserNotFoundException{
	Synthese_Manager s = syntheseManagerService.getByUser(user);
	  return new ResponseEntity<>(s,OK);
	 
}
}
