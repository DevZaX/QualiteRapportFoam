package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Utilisateur;
import com.model.Zone;
import com.service.UtilisateurService;
import com.service.ZoneService;

@Controller
public class ZoneController {
	
	
	
	private ZoneService zoneService;
	private UtilisateurService utilisateurService;
	
	
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}




	@Autowired
	@Qualifier(value="zoneService")
	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}




	@RequestMapping(value="zones/index",method=RequestMethod.GET)
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
		map.addAttribute("zone",new Zone());
	    map.addAttribute("zones", zoneService.listZone());
	    map.addAttribute("utilisateur",u);
	    
		return "zone/index";
	}
	
	@RequestMapping(value="zones/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("zone")Zone zone,BindingResult result,Principal principal)
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
		zoneService.addZone(zone);
		return "redirect:/zones/index";
	}
	
	@RequestMapping(value="zones/{id}/delete",method=RequestMethod.GET)
	public String destory(@PathVariable("id")long id,Principal principal)
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
		zoneService.deleteZone(id);
		return "redirect:/zones/index";
	}
	
	

}
