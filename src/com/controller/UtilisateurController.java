package com.controller;

import java.security.Principal;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.index.UtilisateurIndex;
import com.model.Defaut;
import com.model.Famille;
import com.model.Piece;
import com.model.Projet;
import com.model.Utilisateur;
import com.model.UtilisateurRole;
import com.service.DefautService;
import com.service.FamilleService;
import com.service.FamilleServiceImpl;
import com.service.PieceService;
import com.service.PieceServiceImpl;
import com.service.ProjetService;
import com.service.ProjetServiceImpl;
import com.service.UtilisateurRoleService;
import com.service.UtilisateurService;
import com.wrapper.UtilisateurWrapper;

@Controller
public class UtilisateurController {
	
	private UtilisateurService utilisateurService;
	private ProjetService projetService;
	private FamilleService familleService;
	private PieceService pieceService;
	private UtilisateurRoleService utilisateurRoleService;
	private DefautService defautService;
	
	
	@Autowired
	public void setDefautService(DefautService defautService) {
		this.defautService = defautService;
	}

	@Autowired
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}
	
	@Autowired
	public void setFamilleService(FamilleService familleService) {
		this.familleService = familleService;
	}
	
	
	@Autowired
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}
	
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	
	
	@Autowired
	public void setUtilisateurRoleService(UtilisateurRoleService usr){
		utilisateurRoleService = usr;
	}
	
	
	 @RequestMapping(value = "users/create", method = RequestMethod.GET)
    public String create(ModelMap model,Principal p) {
		 
		    List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }

		    List<String> roles = new ArrayList<String>();
		    roles.add("Technicient qualite");
		    roles.add("Responsable qualite");
		    roles.add("Injenieur qualite");
		    roles.add("Qualite client");
		    roles.add("Coordinatrice");
		    roles.add("Coordinateur injection");
		    roles.add("Coordinateur couture");
		    roles.add("Controlleur reception");
		    model.addAttribute("roles",roles);
	    	model.addAttribute("utilisateurWrapper", new UtilisateurWrapper());
	    	model.addAttribute("utilisateur",u);
	        return "user/create";
	    }
	 
	 
	 @RequestMapping(value="users/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("utilisateurWrapper")UtilisateurWrapper utilisateurWrapper,BindingResult result,Principal p)
	 {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		   Utilisateur utilisateur = new Utilisateur();
		   UtilisateurRole utilisateurRole = new UtilisateurRole();
		   utilisateur.setUsername(utilisateurWrapper.getUsername());
		   utilisateur.setLangue("francais");
		   BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		   utilisateur.setPassword(bCryptPasswordEncoder.encode(utilisateurWrapper.getPassword()));
		   utilisateurService.addUtilisateur(utilisateur);
		   utilisateurRole.setRole(utilisateurWrapper.getRole());
		   utilisateurRole.setUtilisateur(utilisateur);
		   utilisateur.getUtilisateurRoles().add(utilisateurRole);
		   utilisateurRoleService.addUtilisateurRole(utilisateurRole);
		   return "redirect:/users/index";
	 }
	 
	 
	 @RequestMapping(value="users/index",method=RequestMethod.GET)
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
		 List<Utilisateur> utilisateurs = utilisateurService.fetchAll();
		 List<UtilisateurIndex> items = new ArrayList<>();
		 for (Utilisateur utilisateur : utilisateurs) {
			UtilisateurIndex utilisateurIndex = new UtilisateurIndex();
			utilisateurIndex.setId(utilisateur.getId_user());
			utilisateurIndex.setUsername(utilisateur.getUsername());
			utilisateurIndex.setRole(utilisateur.getUtilisateurRoles().get(0).getRole());
			items.add(utilisateurIndex);
		}
		 List<String> roles = new ArrayList<>();
		 roles.add("Technicient qualite");
		    roles.add("Responsable qualite");
		    roles.add("Injenieur qualite");
		    roles.add("Qualite client");
		    roles.add("Coordinatrice");
		    roles.add("Coordinateur injection");
		    roles.add("Coordinateur couture");
		    roles.add("Controlleur reception");
		    
		    map.addAttribute("roles",roles);
		    map.addAttribute("items",items);
		    map.addAttribute("name",p.getName());
		    map.addAttribute("name",u.getUsername());
		    map.addAttribute("role",u.getUtilisateurRoles().get(0));
		    
		 return "user/index";
	 }
	 
	
	 @RequestMapping(value="users/show",method=RequestMethod.GET)
	public String show(Principal p,ModelMap map)
	 {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		 Utilisateur utilisateur = utilisateurService.getUtilisateurByUsername(p.getName());
		 map.addAttribute("user", utilisateur);
		 map.addAttribute("name",u.getUsername());
		 map.addAttribute("role",u.getUtilisateurRoles().get(0));
		 return "user/show";
		
	 }
	 
	 
	 @RequestMapping(value="users/{id}/delete",method=RequestMethod.GET)
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
		 utilisateurService.delete(id);
		 return "redirect:/users/index";
	 }
	 
	 
	 @RequestMapping(value="users/edit",method=RequestMethod.GET)
	public String edit(ModelMap map,Principal p)
	 {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		 map.addAttribute("user", u);
		 map.addAttribute("name",u.getUsername());
		 map.addAttribute("role",u.getUtilisateurRoles().get(0));
		 return "user/edit";
	 }
	 
	 
	 @RequestMapping(value="users/update",method=RequestMethod.POST)
	public String update(@RequestParam("username")String username,

			               @RequestParam("password")String password,
			               @RequestParam("indice")String indice,
			               Principal p)
	 {
		 List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
			Utilisateur utilisateur = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(utilisateur.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }

		  BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		  utilisateur.setUsername(username);
		  utilisateur.setPassword(bCryptPasswordEncoder.encode(password));
		  utilisateur.setIndice(indice);
		 utilisateurService.update(utilisateur);
		 return "redirect:/logout";
	 }
	 
	 
	 @RequestMapping(value="users/recovery",method=RequestMethod.GET)
	public String recovery()
	 {
           return "user/recovery";
	 }
	 
	 
	 @RequestMapping(value="users/forgot",method=RequestMethod.POST)
    public String forgot(@RequestParam("username") String username,
			 RedirectAttributes redirectAttributes)
	 {
           Utilisateur utilisateur = utilisateurService.getUtilisateurByUsername(username);
           if(utilisateur != null)
           {
        	   redirectAttributes.addFlashAttribute("indice", utilisateur.getIndice());
               redirectAttributes.addFlashAttribute("user",utilisateur);
           }
           
           return "redirect:/users/recovery";
          
	 }
	 
	 @RequestMapping(value="users/{langue}",method=RequestMethod.GET)
	 
	 public String changeLangue(@PathVariable("langue")String langue,Principal p,HttpServletRequest request)
	 {
		 Utilisateur utilisateur = utilisateurService.getUtilisateurByUsername(p.getName());
		 utilisateur.setLangue(langue);
		 utilisateurService.update(utilisateur);
		 return "redirect:"+request.getHeader("Referer");
	 }

	 @RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
	        return "login";
	    }
	 
	 
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		    SecurityContextHolder.getContext().setAuthentication(null);
	        return "login";
	    }
	 
	 
	 @RequestMapping(value = "/failer", method = RequestMethod.GET)
	public String failer() {
	        return "login";
	    }
	 
	 
	 @RequestMapping(value="/",method=RequestMethod.GET)
	public String test()
	 {
		 return "home";
	 }
	 


}
