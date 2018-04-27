package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
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

import com.model.Alert;
import com.model.Utilisateur;
import com.model.Zone40F;
import com.service.AlertService;
import com.service.UtilisateurService;
import com.service.Zone40FService;

@Controller
public class Zone40FController {
	
	private Zone40FService zone40FService;
	
	private AlertService alertService;
	
	private UtilisateurService utilisateurService;
	
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	
    @Autowired
    @Qualifier(value="zone40FService")
	public void setZone40FService(Zone40FService zone40fService) {
		zone40FService = zone40fService;
	}

    @Autowired
    @Qualifier(value="alertService")
	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}

	@RequestMapping(value="zone40f/{id_alert}/show",method=RequestMethod.GET)
	public String index(@PathVariable("id_alert")Long id_alert,
			ModelMap map,Principal p)
	{

	    List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		List<Zone40F> zone40fs = zone40FService.fetchAll();
		map.addAttribute("zone40fs",zone40fs);
		map.addAttribute("id_alert",id_alert);
		map.addAttribute("utilisateur",u);
		return "zone40f/index";
	}
	
	@RequestMapping(value="zone40f/store",method=RequestMethod.POST)
	public String store(@RequestParam("id_alert")Long id_alert,
			@RequestParam("qte")int qte,
			@RequestParam("id_mgz")String id_mgz,
			@RequestParam("emplacement")String emplacement,
			HttpServletRequest request)
	{
		Zone40F zone40f = new Zone40F();
		zone40f.setAlert(id_alert);
		zone40f.setDate_mouvement(new Date());
		zone40f.setDate_sortie(null);
		zone40f.setEmplacement(emplacement);
		zone40f.setId_mgz(id_mgz);
		zone40f.setQte(qte);
		zone40FService.save(zone40f);
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="zone40f/{id}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id,HttpServletRequest request,Principal p)
	{

	    List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		zone40FService.delete(id);
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="zone40f/{id}/close",method=RequestMethod.GET)
	public String close(@PathVariable("id")Long id,HttpServletRequest request,Principal p)
	{

	    List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		 Zone40F zone40f = zone40FService.find(id);
		 zone40f.setDate_sortie(new Date());
		 zone40FService.update(zone40f);
		 return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="zone40f/{id}/edit",method=RequestMethod.GET)
	public String edit(@PathVariable("id")Long id,
			ModelMap map,Principal p)
	{

	    List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		List<Zone40F> zone40fs = zone40FService.fetchAll();
		map.addAttribute("zone40fs",zone40fs);
		Zone40F z = zone40FService.find(id);
		map.addAttribute("z",z);
		map.addAttribute("utilisateur",u);
		return "zone40f/edit";
	}
	
	@RequestMapping(value="zone40f/update",method=RequestMethod.POST)
	public String update(@RequestParam("id_alert")Long id_alert,
			@RequestParam("qte")int qte,
			@RequestParam("id_mgz")String id_mgz,
			@RequestParam("emplacement")String emplacement,
			@RequestParam("id")Long id,
			HttpServletRequest request)
	{
		Zone40F zone40f = zone40FService.find(id);
		if(zone40f != null)
		{
			zone40f.setAlert(id_alert);
			zone40f.setEmplacement(emplacement);
			zone40f.setId_mgz(id_mgz);
			zone40f.setQte(qte);
			zone40FService.update(zone40f);
			
		}
		return "redirect:"+request.getHeader("Referer");
		
	}

}
