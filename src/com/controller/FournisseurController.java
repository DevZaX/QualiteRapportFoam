package com.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Fournisseur;
import com.service.FournisseurService;

@Controller
public class FournisseurController {
	
	private FournisseurService fournisseurService;

	@Autowired
	public void setFournisseurService(FournisseurService fournisseurService) {
		this.fournisseurService = fournisseurService;
	}
	
	@RequestMapping(value="fournisseurs/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p) {
		map.addAttribute("items",fournisseurService.fetchAll());
		map.addAttribute("fournisseur",new Fournisseur());
		return "fournisseur/index";
	}
	
	@RequestMapping(value="fournisseurs/{id}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id)
	{
		
		fournisseurService.delete(id);
		return "redirect:/fournisseurs/index";
	}
	
	@RequestMapping(value="fournisseurs/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("fournisseur")Fournisseur fournisseur)
	{
		fournisseurService.save(fournisseur);
		return "redirect:/fournisseurs/index";
	}
	
	

}
