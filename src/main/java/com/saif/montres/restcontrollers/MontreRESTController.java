package com.saif.montres.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.saif.montres.entities.Montre;
import com.saif.montres.service.MontreService;
@RestController
@RequestMapping("/api")
@CrossOrigin
public class MontreRESTController {

	
	
	@Autowired
	MontreService montreService;
	
	
	@RequestMapping( path="all" ,method=RequestMethod.GET)
	public List<Montre> getAllMontres() {
		
		return montreService.getAllMontres();
	}
	
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Montre getMontreById(@PathVariable("id") Long id) {
	return montreService.getMontre(id);
	 }
	
	
	@RequestMapping(value="/addmon", method = RequestMethod.POST)
	public Montre createMontre(@RequestBody Montre montre) {
		
	return montreService.saveMontre(montre);
	}
	
	
	@RequestMapping(value="/updatemon",method = RequestMethod.PUT)
	public Montre updateMontre(@RequestBody Montre montre) {
	return montreService.updateMontre(montre);
	}
	
	@RequestMapping(value="/delmon/{id}",method = RequestMethod.DELETE)
	public void deleteMontre(@PathVariable("id") Long id)
	{
		montreService.deleteMontreById(id);
	}
	@RequestMapping(value="/monsgen/{idGen}",method = RequestMethod.GET)
	public List<Montre> getMontresByGenId(@PathVariable("idGen") Long idGen) {
	return montreService.findByGenreIdGen(idGen);
	}
	
	@RequestMapping(value="/monsByName/{nom}",method = RequestMethod.GET) 
	public List<Montre> findByNomMontreContains(@PathVariable("nom") String nom) { 
	return montreService.findByNomMontreContains(nom); 
	} 

	}
