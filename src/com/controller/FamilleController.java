package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.Famille;
import com.model.Utilisateur;
import com.service.FamilleService;
import com.service.UtilisateurService;
import com.wrapper.FamilleWrapper;

@Controller
public class FamilleController {
	
	
	private FamilleService familleService;
	private UtilisateurService utilisateurService;

	@Autowired
	@Qualifier(value="familleService")
	public void setFamilleService(FamilleService familleService) {
		this.familleService = familleService;
	}
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	
	@RequestMapping(value="familles/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal principal)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
	
		Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
		
		
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		List<Famille> items = familleService.fetchAll();
		map.addAttribute("items", items);
		map.addAttribute("utilisateur",u);
		return "famille/index";
	}
	
	@RequestMapping(value="familles/update",method=RequestMethod.POST)
	public String update(@RequestParam("price") Double price,
			@RequestParam("weight") Double weight,
			@RequestParam("title") String title,
			Principal principal)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
	
		Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
		
		
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		
		Famille famille = familleService.getFamilleByTitle(title);
		famille.setPrice(price);
		famille.setWeight(weight);
		familleService.update(famille);
		return "redirect:/familles/index";
		
	}
	
	

}
