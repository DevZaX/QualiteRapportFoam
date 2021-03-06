package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Phase;
import com.model.Utilisateur;
import com.service.PhaseService;
import com.service.UtilisateurService;

@Controller
public class PhaseController {
	
	private PhaseService phaseService;
	private UtilisateurService utilisateurService;
	
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}

	@Autowired
	public void setPhaseService(PhaseService phaseService) {
		this.phaseService = phaseService;
	}
	
	//create
	
	@RequestMapping(value="phases/create",method=RequestMethod.GET)
	public String create(ModelMap map,Principal p)
	{
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		map.addAttribute("phase",new Phase());
		map.addAttribute("utilisateur",u);
		return "phase/create";
	}
	
	//store
	
	@RequestMapping(value="phases/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("phase")Phase phase)
	{
		phaseService.save(phase);
		return "redirect:/phases/index";
	}
	
	//delete
	
	@RequestMapping(value="phases/{id}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id,Principal p)
	{
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		Phase phase = phaseService.find(id);
		phaseService.delete(phase);
		return "redirect:/phases/index";
	}
	
	//index
	
	@RequestMapping(value="phases/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p)
	{
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		List<Phase> items = phaseService.fetchAll();
		map.addAttribute("items",items);
		map.addAttribute("utilisateur",u);
		return "phase/index";
	}
	
	//update
	
	@RequestMapping(value="phases/update",method=RequestMethod.POST)
	public String update(@RequestParam("id")Long id,
			@RequestParam("title") String title,
			@RequestParam("duree")int duree) {
		Phase phase = phaseService.find(id);
		phase.setDuree(duree);
		phase.setTitle(title);
		phaseService.update(phase);
		return "redirect:/phases/index";
	}
	

}
