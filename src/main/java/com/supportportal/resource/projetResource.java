package com.supportportal.resource;

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
import org.springframework.http.HttpStatus;

import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.service.ProjetService;
import com.supportportal.service.UserService;

import static org.springframework.http.HttpStatus.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path = {"/projet"})
public class projetResource {
private ProjetService projetService;
private UserService userService;
public static final String PROJET_DELETED_SUCCESSFULLY = "project deleted successfully";
public static final String PROJET_EXIST = "project name already exist";

public projetResource(ProjetService projetService,UserService userService) {
	super();
	this.projetService = projetService;
	this.userService = userService;
}


@PostMapping("/add")
public ResponseEntity<?> addProjet(@RequestParam("titre") String titre,
        @RequestParam("description") String description,
        @RequestParam("etat") String etat,
        @RequestParam("duree") String duree,
        @RequestParam("client") String client,
        @RequestParam("chef") String chef)throws UserNotFoundException{
	  Projet projet = projetService.addProject(titre, description, etat, duree, client, chef);
	  if(projet==null) {
		  return response(OK, PROJET_EXIST);
	  }
	  else return new ResponseEntity<>(projet,OK);
	 
}

@PostMapping("/update")
public ResponseEntity<Projet> updateProjet(@RequestParam("id") Long id,@RequestParam("titre") String titre,
        @RequestParam("description") String description,
        @RequestParam("etat") String etat,
        @RequestParam("duree") String duree,
        @RequestParam("client") String client,
        @RequestParam("chef") String chef){
	
	  User u =  userService.findUserByUsername(chef);
	  Projet projet = projetService.updateProject(id,titre, description, etat, duree, client, u);
	
	return new ResponseEntity<>(projet,OK);
}
@DeleteMapping("/delete/{titre}")
@PreAuthorize("hasAnyAuthority('user:delete')")
public ResponseEntity<HttpResponse> deleteUser(@PathVariable("titre") String titre) throws IOException {
    projetService.deleteProject(titre);
    return response(OK, PROJET_DELETED_SUCCESSFULLY);
}

@GetMapping("/list")
public ResponseEntity<List<Projet>> getAllUsers() {
	
	
    List<Projet> projets = projetService.getProjects();
    
    
            return new ResponseEntity<>(projets, OK);
}
@GetMapping("/list/{client}")
public ResponseEntity<List<Projet>> getProjetsByClients(@PathVariable("client") String client)throws IOException  {
	
	
    List<Projet> projets = projetService.findProjectByClient(client);
    
    
            return new ResponseEntity<>(projets, OK);
}

@GetMapping("/{titre}")
public ResponseEntity<Projet> getProjetByTitle(@PathVariable("titre") String titre)throws IOException  {
	
	
    Projet projets = projetService.getProject(titre);
    
    
            return new ResponseEntity<>(projets, OK);
}



private ResponseEntity<HttpResponse> response(HttpStatus httpStatus, String message) {
    return new ResponseEntity<>(new HttpResponse(httpStatus.value(), httpStatus, httpStatus.getReasonPhrase().toUpperCase(),
            message), httpStatus);
}

}
