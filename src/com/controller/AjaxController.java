package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.model.Utilisateur;
import com.service.UtilisateurService;

@Controller
public class AjaxController {
	
	private UtilisateurService utilisateurService;
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	
	
	@RequestMapping(value="ajax/test",method=RequestMethod.POST)
	@ResponseBody
	public String usersSize(@RequestParam("id")Long id)
	{
		System.err.println(id);
		return "good";
	}

}
