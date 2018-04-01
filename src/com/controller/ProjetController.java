package com.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
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

import com.index.ProjetIndex;
import com.model.Famille;
import com.model.Piece;
import com.model.Projet;
import com.model.Utilisateur;
import com.service.FamilleService;
import com.service.PieceService;
import com.service.ProjetService;
import com.service.UtilisateurService;
import com.wrapper.ProjetWrapper;

@Controller
public class ProjetController {
	
	
	private ProjetService projetService;
    private FamilleService familleService;
	private PieceService pieceService;
	private UtilisateurService utilisateurService;
	
	
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Autowired
	@Qualifier(value="projetService")
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}
	
	@Autowired
	@Qualifier(value="familleService")
	public void setFamilleService(FamilleService familleService) {
		this.familleService = familleService;
	}

	@Autowired
	@Qualifier(value="pieceService")
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}

	@RequestMapping(value="projets/store",method=RequestMethod.POST)
	public String store(ModelMap map,@ModelAttribute("projetWrapper")ProjetWrapper projetWrapper,BindingResult result,Principal principal)
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
		
		Projet pt = projetService.getProjetByTitle(projetWrapper.getTitle());
		Famille ft = familleService.getFamilleByTitle(projetWrapper.getFamille());
		
		if(ft == null)
		{
			if(pt == null)
			{
				Projet p = new Projet();
				p.setTitle(projetWrapper.getTitle());
				
				projetService.saveOrUpdateProjet(p);
				
				Famille f = new Famille();
				f.setTitle(projetWrapper.getFamille());
				
				f.setProjet(p);
				p.getFamilles().add(f);
				familleService.save(f);
				
				
				Piece pi = new Piece();
				pi.setRef(projetWrapper.getRef().toUpperCase());
				pi.setVersion(projetWrapper.getVersion());
				
				pi.setFamille(f);
				f.getPieces().add(pi);
				pi.setFamille(f);
				pi.setEtat(1);
				pieceService.addPiece(pi);
				
			}else {
				Famille f = new Famille();
				f.setTitle(projetWrapper.getFamille());
				
				f.setProjet(pt);
				pt.getFamilles().add(f);
				familleService.save(f);
				
				
				Piece pi = new Piece();
				pi.setRef(projetWrapper.getRef().toUpperCase());
				pi.setVersion(projetWrapper.getVersion());
				
				pi.setFamille(f);
				f.getPieces().add(pi);
				pi.setFamille(f);
				pi.setEtat(1);
				pieceService.addPiece(pi);
			}
		}else {
			Piece pi = new Piece();
			pi.setRef(projetWrapper.getRef().toUpperCase());
			pi.setVersion(projetWrapper.getVersion());
			
			pi.setFamille(ft);
			ft.getPieces().add(pi);
			pi.setFamille(ft);
			pi.setEtat(1);
			pieceService.addPiece(pi);
		}
		
		return "redirect:/projets/index";
	}
	
	
	@RequestMapping(value="projets/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal principal)
	{
		
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Qualite client");
		roles.add("Coordinateur injection");
	
		Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
		
		
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		
		
		List<ProjetIndex> items = new ArrayList<>();
		List<Projet> projets = projetService.getProjets();
		for (Projet projet : projets) {
			List<Famille> familles = projet.getFamilles();
			for (Famille famille : familles) {
				List<Piece> pieces = famille.getPieces();
				for (Piece piece : pieces) {
					
					 if(piece.getEtat() == 1)
					 {
						 ProjetIndex projetIndex = new ProjetIndex();
						 projetIndex.setTitle(projet.getTitle());
						 projetIndex.setFamille(famille.getTitle());
						 projetIndex.setRef(piece.getRef());
						 projetIndex.setVersion(piece.getVersion());
						 projetIndex.setId(projet.getId());
						 items.add(projetIndex);
					 }
				}
			}
		}
		
		map.addAttribute("items", items);
		map.addAttribute("projetWrapper",new ProjetWrapper());
		map.addAttribute("utilisateur",u);
		
		return "projet/index";
	}
	
	
	
	
	@RequestMapping(value="projets/{ref}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("ref")String ref,Principal principal)
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
		Piece piece = pieceService.find(ref);
		
		piece.setEtat(0);
		pieceService.update(piece);
		
		return "redirect:/projets/index";
	}
	
	

}
