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

import com.model.Piece;
import com.model.Utilisateur;
import com.service.PieceService;
import com.service.UtilisateurService;

@Controller
public class PieceController {
	
	private PieceService pieceService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	@Qualifier(value="pieceService")
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	
	@RequestMapping(value="pieces/index",method=RequestMethod.GET)
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
		List<Piece> pieces = pieceService.fetchAll();
		map.addAttribute("pieces",pieces);
		map.addAttribute("utilisateur",u);
		return "piece/index";
	}
	
	@RequestMapping(value="pieces/update",method=RequestMethod.POST)
	public String update(@RequestParam("ref")String ref,@RequestParam("priceappt")Double priceappt,Principal principal,@RequestParam("prototype")String prototype)
	{
		
	    Piece piece = pieceService.find(ref);
	    piece.setPrice(priceappt);
	    piece.setPrototype(prototype);
	    pieceService.update(piece);
		return "redirect:/pieces/index";
	}

}
