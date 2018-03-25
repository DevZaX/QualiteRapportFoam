package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Empiecement;
import com.model.Fournisseur;
import com.model.Projet;
import com.model.Utilisateur;
import com.service.EmpiecementService;
import com.service.FournisseurService;
import com.service.ProjetService;
import com.service.UtilisateurService;

import javassist.tools.framedump;

@Controller
public class EmpiecementController {
	
	
	private EmpiecementService empiecementService;
	private ProjetService projetService;
	private FournisseurService fournisseurService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@Autowired
	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}

	@Autowired
	public void setEmpiecementService(EmpiecementService empiecementService) {
		this.empiecementService = empiecementService;
	}

    @Autowired
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}

	@RequestMapping(value="empiecements/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
		
		Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		List<Empiecement> items = empiecementService.fetchAll();
		List<Projet> elements = projetService.fetchAll();
		map.addAttribute("items",items);
		map.addAttribute("elements", elements);
		map.addAttribute("name",p.getName());
		map.addAttribute("empiecement",new Empiecement());
		map.addAttribute("utilisateur",u);
		List<Projet> items2 = projetService.fetchAll();
		List<Fournisseur> items3 = fournisseurService.fetchAll();
		map.addAttribute("items2",items2);
		map.addAttribute("items3",items3);
		return "empiecement/index";
	}
	
	
	
	@RequestMapping(value="empiecements/store",method=RequestMethod.POST)
	public String store(@RequestParam("projet")String projet,
			@RequestParam("fournisseur")String fournisseur,
			@ModelAttribute("empiecement")Empiecement empiecement,
			BindingResult result,Principal p)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
		
		Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		
		empiecement.setProjet(projetService.getProjetByTitle(projet));
		empiecement.setFournisseur(fournisseur);
		empiecementService.save(empiecement);
		return "redirect:/empiecements/index";
	}
	
	
	
	
	@RequestMapping(value="empiecements/update",method=RequestMethod.POST)
	public String update(@RequestParam("ref")String ref,
			@RequestParam("version")String version,
			@RequestParam("fournisseur")String fournisseur,
			@RequestParam("price")Double price,
			@RequestParam("title")String title,
			@RequestParam("projet")String projet,
			Principal p)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
		
		Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		
		Empiecement em =  empiecementService.getEmpiecementByRef(ref);
		em.setFournisseur(fournisseur);
		em.setPrice(price);
		em.setRef(ref);
		em.setVersion(version);
		em.setProjet(projetService.getProjetByTitle(projet));
		empiecementService.update(em);
		return "redirect:/empiecements/index";
	}
	
	
	@RequestMapping(value="empiecements/{ref}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("ref")String ref,Principal p)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
		
		Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		Empiecement em =  empiecementService.getEmpiecementByRef(ref);
		empiecementService.delete(em);
		return "redirect:/empiecements/index";
	}

}
