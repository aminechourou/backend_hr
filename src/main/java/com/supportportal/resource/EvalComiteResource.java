package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.EvalComite;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.EvalComiteService;

@RestController
@RequestMapping(path = {"/evalComite"})
public class EvalComiteResource {
   EvalComiteService evalComiteService;
   
	public EvalComiteResource(EvalComiteService evalComiteService) {
	super();
	this.evalComiteService = evalComiteService;
}
	@PostMapping("/add")
	public ResponseEntity<?> addTrajectoire(@RequestParam("user") String user)throws UserNotFoundException{
		  EvalComite s = evalComiteService.add(user);
		  return new ResponseEntity<>(s,OK);
		 
	}
	@PostMapping("/update")
	public ResponseEntity<?> updateTrajectoire(@RequestParam("user") String user,@RequestParam("mission")String mission,
			@RequestParam("attenduVSrank")String attenduVSrank, @RequestParam("contributions") String contributions,
			@RequestParam("appreciation")String appreciation, @RequestParam("synthese_globale")String synthese_globale)throws UserNotFoundException{
		  EvalComite s = evalComiteService.update(mission, attenduVSrank, contributions, appreciation, synthese_globale, user);
		  return new ResponseEntity<>(s,OK);
		 
	}

	@GetMapping("/getEvalComite")
	public ResponseEntity<?> getTrajectoire(@RequestParam("user") String user)throws UserNotFoundException{
		  EvalComite s = evalComiteService.get(user);
		  return new ResponseEntity<>(s,OK);
		 
	}
}
