package com.supportportal.resource;

import static org.springframework.http.HttpStatus.OK;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.supportportal.domain.HttpResponse;
import com.supportportal.domain.Objectives;
import com.supportportal.domain.Synthese_Manager;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.ObjectivesServices;

@RestController
@RequestMapping(path = {"/objectives"})
public class ObjectivesResources {
ObjectivesServices objectivesServices;
public static final String OBJECTIVE_DELETED_SUCCESSFULLY = "objective deleted successfully";

public ObjectivesResources(ObjectivesServices objectivesServices) {
	super();
	this.objectivesServices = objectivesServices;
}

@PostMapping("/add")
public ResponseEntity<?> addObjectives(@RequestParam("description") String desc,@RequestParam("etat") String etat,@RequestParam("user") String user)throws UserNotFoundException{
	  Objectives s = objectivesServices.add(desc,etat,user);
	  return new ResponseEntity<>(s,OK);
	 
}

@DeleteMapping("/delete")

public ResponseEntity<HttpResponse> deleteUser(@RequestParam("id") Long id) throws IOException {
    objectivesServices.delete(id);
    return response(OK, OBJECTIVE_DELETED_SUCCESSFULLY);

}

@PostMapping("/updateDescription")
public ResponseEntity<?> updateObjectivesDescription(@RequestParam("description") String desc,@RequestParam("id") Long id)throws UserNotFoundException{
	  Objectives s = objectivesServices.updateDescription(id,desc);
	  return new ResponseEntity<>(s,OK);
	 
}

@PostMapping("/updateEtat")
public ResponseEntity<?> updateObjectivesEtat(@RequestParam("id") Long id)throws UserNotFoundException{
	  Objectives s = objectivesServices.updateEtat(id);
	  return new ResponseEntity<>(s,OK);
	 
}

@GetMapping("/list")
public ResponseEntity<?>listObjectivesWithUser(@RequestParam("user") String user)throws UserNotFoundException{
	 List<Objectives> list = objectivesServices.getObjectiveByUser(user);
	  return new ResponseEntity<>(list,OK);
	 
}





private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
            message), httpStatus);
}
}
