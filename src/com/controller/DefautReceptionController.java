package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.DefautReception;
import com.model.Utilisateur;
import com.service.DefautReceptionService;
import com.service.UtilisateurService;

@Controller
public class DefautReceptionController {
	
	private DefautReceptionService defautReceptionService;
	private UtilisateurService utilisateurService;
	
	

	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	

	@Autowired
	public void setDefautReceptionService(DefautReceptionService defautReceptionService) {
		this.defautReceptionService = defautReceptionService;
	}
	
	@RequestMapping(value="dreception/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p) {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		List<DefautReception> items = defautReceptionService.fetchAll();
		map.addAttribute("items", items);
		map.addAttribute("utilisateur",u);
		return "defautReception/index";
	}
	
	@RequestMapping(value="dreception/create",method=RequestMethod.GET)
	public String create(ModelMap map,Principal p) {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		map.addAttribute("defautReception",new DefautReception());
		map.addAttribute("utilisateur",u);
		return "defautReception/create";
	}
	
	@RequestMapping(value="dreception/{code}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("code")String code,Principal p,ModelMap model) {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		DefautReception defautReception = defautReceptionService.findByCode(code);
		defautReceptionService.delete(defautReception);
		model.addAttribute("utilisateur",u);
		return "redirect:/dreception/index";
	}
	
	
	@RequestMapping(value="dreception/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("defautReception")DefautReception defautReception)
	{
		defautReceptionService.save(defautReception);
		return "redirect:/dreception/index";
	}
	
	

}
