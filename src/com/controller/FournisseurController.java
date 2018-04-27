package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Fournisseur;
import com.model.Utilisateur;
import com.service.FournisseurService;
import com.service.UtilisateurService;

@Controller
public class FournisseurController {
	
	private FournisseurService fournisseurService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	

	@Autowired
	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	@RequestMapping(value="fournisseurs/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p) {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }

		map.addAttribute("items",fournisseurService.fetchAll());
		map.addAttribute("fournisseur",new Fournisseur());
		map.addAttribute("utilisateur",u);
		return "fournisseur/index";
	}
	
	@RequestMapping(value="fournisseurs/{id}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id,Principal p,ModelMap model)
	{
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }

		fournisseurService.delete(id);
		model.addAttribute("utilisateur",u);
		return "redirect:/fournisseurs/index";
	}
	
	@RequestMapping(value="fournisseurs/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("fournisseur")Fournisseur fournisseur)
	{
		fournisseurService.save(fournisseur);
		return "redirect:/fournisseurs/index";
	}
	
	

}
