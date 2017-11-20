package dev.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.repository.*;
import dev.entity.*;

@RestController
@CrossOrigin(origins="*")
public class Controller {

	@Autowired CollaborateurRepository collaborateurRepository;
	
	
	@RequestMapping(value="/collegues",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<Collaborateur> listCollaborateurs(){
		return collaborateurRepository.findAll();
		
	}
	
	@RequestMapping(value="/collegues",method=RequestMethod.POST,produces = "application/json")
	public @ResponseBody Collaborateur matricule(@RequestBody Collaborateur collaborateur){
		return collaborateurRepository.save(collaborateur);
		
	}
	
	@RequestMapping(value="/collegues/{score}",method=RequestMethod.PUT)
	public @ResponseBody Collaborateur modification(@PathVariable(value ="score")int score,@RequestBody Collaborateur collaborateur){
		Collaborateur newCollaborateur= collaborateurRepository.findByNom(collaborateur.getNom());
		
		newCollaborateur.setScore(newCollaborateur.getScore()+score);
		
		return collaborateurRepository.save(newCollaborateur);
		
	}
	
}
