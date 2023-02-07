package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.Projet;
import com.supportportal.domain.SyntheseAutoEval;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.SyntheseAutoEvalService;

@RestController
@RequestMapping(path = {"/autoEval"})
public class SyntheseAutoEvalResource {
SyntheseAutoEvalService syntheseAutoEvalService;

public SyntheseAutoEvalResource(SyntheseAutoEvalService syntheseAutoEvalService) {
	super();
	this.syntheseAutoEvalService = syntheseAutoEvalService;
}
@PostMapping("/add")
public ResponseEntity<?> addAutoEval(@RequestParam("user") String user)throws UserNotFoundException{
	  SyntheseAutoEval s = syntheseAutoEvalService.add(user);
	  return new ResponseEntity<>(s,OK);
	 
}

@PostMapping("/update")
public ResponseEntity<?> updateAutoEval(@RequestParam("user") String user,@RequestParam("champ") String champ,@RequestParam("value") String value)throws UserNotFoundException{
	  SyntheseAutoEval s = syntheseAutoEvalService.update(user, champ, value);
	  return new ResponseEntity<>(s,OK);
	 
}
@GetMapping("/getAutoEvalByUser")
public ResponseEntity<?> getAutoEval(@RequestParam("user") String user)throws UserNotFoundException{
	  SyntheseAutoEval s = syntheseAutoEvalService.getByUser(user);
	  return new ResponseEntity<>(s,OK);
	 
}

}
