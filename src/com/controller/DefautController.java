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

import com.model.Defaut;
import com.model.Utilisateur;
import com.service.DefautService;
import com.service.UtilisateurService;

@Controller
public class DefautController {
	
	@Autowired
	private DefautService defautService;
	
	private UtilisateurService utilisateurService;

	@Qualifier(value="defautService")
	public void setDefautService(DefautService defautService) {
		this.defautService = defautService;
	}
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	
	
	/* afficher toutes les defauts */
	@RequestMapping(value="defauts/index",method = RequestMethod.GET)
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
		List<Defaut> defauts = defautService.listDefaut();
		map.addAttribute("defauts",defauts);
		map.addAttribute("utilisateur",u);
		return "defaut/index";
	}
	
	
	@RequestMapping(value="defauts/create",method = RequestMethod.GET)
	public String create(ModelMap map,Principal p)
	{          List<String> access = new ArrayList<String>();
			    access.add("Technicient qualite");
			    access.add("Responsable qualite");
			    access.add("Injenieur qualite");
			    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
			    
			    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
			    	return "denied";
			    }
		       String[] sides = {"right-1","bottom","top","left-1","left-2","right-2"};
		       map.addAttribute("sides",sides);
		       map.addAttribute("defaut", new Defaut());
		       map.addAttribute("utilisateur",u);
				return "defaut/create";
	}
	
	
	@RequestMapping(value="defauts/store",method = RequestMethod.POST)
	public String store(@ModelAttribute("defaut")Defaut defaut,BindingResult result)
	{             
		        defautService.addDefaut(defaut);
				return "redirect:/defauts/index";
	}
	
	
	@RequestMapping(value="defauts/{code}/delete",method = RequestMethod.GET)
	public String destroy(@PathVariable("code")String  code,Principal p,ModelMap map)
	{             
				List<String> access = new ArrayList<String>();
			    access.add("Technicient qualite");
			    access.add("Responsable qualite");
			    access.add("Injenieur qualite");
			    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
			    
			    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
			    	return "denied";
			    }
			    map.addAttribute("utilisateur",u);
		        defautService.removeDefaut(code);
				return "redirect:/defauts/index";
	}
	
	
	
	

}
