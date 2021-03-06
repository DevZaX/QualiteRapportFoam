package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.ControlReception;
import com.model.DefautControlReception;
import com.model.DefautReception;
import com.model.Utilisateur;
import com.service.ControlReceptionService;
import com.service.DefautControlReceptionService;
import com.service.DefautReceptionService;
import com.service.UtilisateurService;

@Controller
public class DefautControlReceptionController {
	
	private UtilisateurService utilisateurService;
	private ControlReceptionService controlReceptionService;
	private DefautControlReceptionService defautControlReceptionService;
	private DefautReceptionService defautReceptionService;
	
	
	
	@Autowired
	@Qualifier(value="defautReceptionService")
	public void setDefautReceptionService(DefautReceptionService defautReceptionService) {
		this.defautReceptionService = defautReceptionService;
	}
	
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	@Autowired
	@Qualifier(value="controlReceptionService")
	public void setControlReceptionService(ControlReceptionService controlReceptionService) {
		this.controlReceptionService = controlReceptionService;
	}
	@Autowired
	@Qualifier(value="defautControlReceptionService")
	public void setDefautControlReceptionService(DefautControlReceptionService defautControlReceptionService) {
		this.defautControlReceptionService = defautControlReceptionService;
	}
	
	@RequestMapping(value="defaut_controle_reception/{id}/create",method=RequestMethod.GET)
	public String create(@PathVariable("id")Long id,Principal p,ModelMap map)
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
		
		List<DefautReception> defautReceptions = defautReceptionService.fetchAll();
		map.addAttribute("defautReceptions",defautReceptions);
		 
		ControlReception controlReception = controlReceptionService.find(id);
		List<DefautControlReception> defautControlReceptions = controlReception.getDefautControlReceptions();
		map.addAttribute("defautControlReceptions",defautControlReceptions);
		map.addAttribute("id",id);
		map.addAttribute("defautControlReception",new DefautControlReception());
		map.addAttribute("utilisateur",u);
		return "defautcr/create";
	}
	
	@RequestMapping(value="defaut_controle_reception/{id}/store",method=RequestMethod.POST)
	public String store(@PathVariable("id")Long id,Principal p,
			@RequestParam("defaut")String defaut,
			@RequestParam("qte")int qte,
			HttpServletRequest request)
	{
		
		ControlReception controlReception = controlReceptionService.find(id);
		DefautControlReception defautControlReception = new DefautControlReception();
		DefautReception defautReception = defautReceptionService.findByTitle(defaut);
		defautControlReception.setTitle(defaut);
		defautControlReception.setCode(defautReception.getCode());
		defautControlReception.setQte(qte);
		defautControlReception.setEtat(1);
		defautControlReception.setControlReception(controlReception);
		
		controlReception.getDefautControlReceptions().add(defautControlReception);
		
		defautControlReceptionService.save(defautControlReception);
		
		
		
		
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="defaut_controle_reception/{id}/delete",method=RequestMethod.GET)
	
	public String destroy(@PathVariable("id")Long id,Principal p,HttpServletRequest request,ModelMap map)
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
		
		DefautControlReception defautControlReception = defautControlReceptionService.find(id);
		
		ControlReception controlReception = defautControlReception.getControlReception();
		
		List<DefautControlReception> defautControlReceptions = controlReception.getDefautControlReceptions();
		
		defautControlReceptions.remove(defautControlReception);
		
		controlReception.getDefautControlReceptions().clear();
		
		controlReception.setDefautControlReceptions(defautControlReceptions);
		
		controlReceptionService.update(controlReception);
		
		map.addAttribute("utilisateur",u);
		
		
		
		
		return "redirect:"+request.getHeader("Referer");
	}

}
