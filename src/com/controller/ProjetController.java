package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.index.PrixIndex;
import com.index.ProjetIndex;
import com.model.Famille;
import com.model.Picture;
import com.model.Piece;
import com.model.Poste;
import com.model.PosteForPiece;
import com.model.Projet;
import com.model.Utilisateur;
import com.service.FamilleService;
import com.service.PieceService;
import com.service.ProjetService;
import com.service.UtilisateurService;
import com.service.ZoneService;
import com.wrapper.ProjetWrapper;
import com.wrapper.PrixWrapper;

@Controller
public class ProjetController {
	
	
	private ProjetService projetService;
    private FamilleService familleService;
	private PieceService pieceService;
	private UtilisateurService utilisateurService;
	private ZoneService zoneService;
	
	
	
	
	@Autowired
	@Qualifier(value="zoneService")
	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}

	
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
	public String store(ModelMap map,@ModelAttribute("projetWrapper")ProjetWrapper projetWrapper,BindingResult result,Principal principal,HttpServletRequest servletRequest)
	{
		Projet pt = projetService.getProjetByTitle(projetWrapper.getTitle());
		Famille ft = familleService.getFamilleByTitle(projetWrapper.getFamille());
		List<MultipartFile> files =projetWrapper.getImages();
		if(files == null || files.size()==0) return "redirect:/projets/index";
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
				pi.setPrototype(projetWrapper.getPrototype());
				pi.setFamille(f);
				f.getPieces().add(pi);
				pi.setFamille(f);
				pieceService.addPiece(pi);
				for (String post : projetWrapper.getPosts()) {
					PosteForPiece posteForPiece = new PosteForPiece();
					posteForPiece.setTitle(post);
					posteForPiece.setPiece(pi);
					pi.getPosteForPieces().add(posteForPiece);
					zoneService.addPosteForPiece(posteForPiece);
				}
				for (MultipartFile multipartFile : files) {
					
					 try
		                {
						    Picture picture = new Picture();
						    picture.setPicture(multipartFile.getBytes());
						    picture.setPiece(pi);
						    pi.getImages().add(picture);
						    pieceService.savePicture(picture);
  
		                } catch (IOException e)
		                {
		                    e.printStackTrace();
		                }
				}
				
				
			}else {
				
				Famille f = new Famille();
				f.setTitle(projetWrapper.getFamille());
				f.setProjet(pt);
				pt.getFamilles().add(f);
				familleService.save(f);
				Piece pi = new Piece();
				pi.setRef(projetWrapper.getRef().toUpperCase());
				pi.setVersion(projetWrapper.getVersion());
				pi.setPrototype(projetWrapper.getPrototype());
				pi.setFamille(f);
				f.getPieces().add(pi);
				pieceService.addPiece(pi);
				for (String post : projetWrapper.getPosts()) {
					PosteForPiece posteForPiece = new PosteForPiece();
					posteForPiece.setTitle(post);
					posteForPiece.setPiece(pi);
					pi.getPosteForPieces().add(posteForPiece);
					zoneService.addPosteForPiece(posteForPiece);
					
				}
				for (MultipartFile multipartFile : files) {
					
					 try
		                {
						    Picture picture = new Picture();
						    picture.setPicture(multipartFile.getBytes());
						    picture.setPiece(pi);
						    pi.getImages().add(picture);
						    pieceService.savePicture(picture);
 
		                } catch (IOException e)
		                {
		                    e.printStackTrace();
		                }
				}		
			}
		}else {
		
			Piece pi = new Piece();
			pi.setRef(projetWrapper.getRef().toUpperCase());
			pi.setVersion(projetWrapper.getVersion());
			pi.setPrototype(projetWrapper.getPrototype());
			pi.setFamille(ft);
			ft.getPieces().add(pi);
			pieceService.addPiece(pi);
			for (String post : projetWrapper.getPosts()) {
				PosteForPiece posteForPiece = new PosteForPiece();
				posteForPiece.setTitle(post);
				posteForPiece.setPiece(pi);
				pi.getPosteForPieces().add(posteForPiece);
				zoneService.addPosteForPiece(posteForPiece);
				
			}
			for (MultipartFile multipartFile : files) {
				
				 try
	                {
					    Picture picture = new Picture();
					    picture.setPicture(multipartFile.getBytes());
					    picture.setPiece(pi);
					    pi.getImages().add(picture);
					    pieceService.savePicture(picture);

	                } catch (IOException e)
	                {
	                    e.printStackTrace();
	                }
			}
		}
		
		return "redirect:/projets/index";
	}
	
	
	@RequestMapping(value="projets/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal principal) throws UnsupportedEncodingException
	{
        List<Poste> postes = zoneService.fetchAllPostes() ;
		
		map.addAttribute("postes",postes);
		
	
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

						 ProjetIndex projetIndex = new ProjetIndex();
						 projetIndex.setTitle(projet.getTitle());
						 projetIndex.setFamille(famille.getTitle());
						 projetIndex.setRef(piece.getRef());
						 projetIndex.setVersion(piece.getVersion());
						 projetIndex.setId(projet.getId());
						 projetIndex.setFamilleId(famille.getId());
						 if(piece.getImages().size() != 0) {
							 byte[] encodeBase64 = Base64.encodeBase64(piece.getImages().get(0).getPicture());
					         String base64Encoded = new String(encodeBase64, "UTF-8");
							 projetIndex.setPicture(base64Encoded);
						 }
						
						 projetIndex.setPrototype(piece.getPrototype());
						 items.add(projetIndex);

				}
			}
		}
		
		map.addAttribute("items", items);
		map.addAttribute("projetWrapper",new ProjetWrapper());
		map.addAttribute("utilisateur",u);
		
		return "projet/index";
	}
	
	
	
	
	@RequestMapping(value="projets/{id}/{ref}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id,
			@PathVariable("ref")String ref,
			Principal principal)
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
		piece.setImages(null);
		piece.setPosteForPieces(null);
		pieceService.update(piece);
		Famille f = familleService.find(id);
		List<Piece> pieces = f.getPieces();
		f.setPieces(null);
		familleService.update(f);
		pieces.remove(piece);
		f.setPieces(pieces);
		familleService.update(f);
		return "redirect:/projets/index";
	}
	
	
	
	@RequestMapping(value="projets/create",method=RequestMethod.GET)
	public String create(ModelMap map,
			Principal principal)
	{
		List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
        List<Poste> postes = zoneService.fetchAllPostes() ;
		map.addAttribute("postes",postes);
		map.addAttribute("projetWrapper",new ProjetWrapper());
	    map.addAttribute("utilisateur",u);
		return "projet/create";
	}
	
	@RequestMapping(value="prix/index",method=RequestMethod.GET)
	public String prixIndex(ModelMap map,Principal principal
			)
	{
		List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		List<PrixIndex> items = new ArrayList<>();
		List<Projet> projets = projetService.getProjets();
		for (Projet projet : projets) {
			List<Famille> familles = projet.getFamilles();
			for (Famille famille : familles) {
				List<Piece> pieces = famille.getPieces();
				for (Piece piece : pieces) {
					PrixIndex prixIndex = new PrixIndex();
					prixIndex.setRef(piece.getRef());
					prixIndex.setVersion(piece.getVersion());
					prixIndex.setId(famille.getId());
					prixIndex.setPriceA(piece.getPrice());
					prixIndex.setPriceP(famille.getPrice());
					prixIndex.setPoidsP(famille.getWeight());
					prixIndex.setPrototype(piece.getPrototype());
				    items.add(prixIndex);
				}
			}
		}
		map.addAttribute("items", items);
		map.addAttribute("utilisateur",u);
	
		return "projet/prixIndex";
	}
	
	
	@RequestMapping(value="prix/{ref}/{id}/edit",method=RequestMethod.GET)
	public String prixEdit(ModelMap map,
			@PathVariable("id")Long id,
			@PathVariable("ref")String ref,Principal principal)
	{
		List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		Piece piece = pieceService.find(ref); 
		Famille famille = familleService.find(id);
		PrixWrapper prixWrapper = new PrixWrapper();
		prixWrapper.setId(id);
		prixWrapper.setRef(ref);
		prixWrapper.setVersion(piece.getVersion());
		prixWrapper.setPriceA(piece.getPrice());
		prixWrapper.setPriceP(famille.getPrice());
		prixWrapper.setPoidsP(famille.getWeight());
		prixWrapper.setPrototype(piece.getPrototype());
		map.addAttribute("prixWrapper",prixWrapper);
		map.addAttribute("utilisateur",u);
		return "projet/prixEdit";
	}
	
	@RequestMapping(value="prix/update",method=RequestMethod.POST)
	public String prixUpdate(@ModelAttribute("prixWrapper")PrixWrapper prixWrapper)
	{
		 Piece piece = pieceService.find(prixWrapper.getRef());
		 piece.setPrice(prixWrapper.getPriceA());
		 piece.setPrototype(prixWrapper.getPrototype());
		 pieceService.update(piece);
		 
		 Famille famille = familleService.find(prixWrapper.getId());
		 famille.setPrice(prixWrapper.getPriceP());
		 famille.setWeight(prixWrapper.getPoidsP());
		 familleService.update(famille);
		
		return "redirect:/prix/index";
	}
	
	
	@RequestMapping(value="projets/{ref}/show",method=RequestMethod.GET)
	public String show(@PathVariable("ref")String ref,ModelMap map,Principal principal)
	{
		List<String> access = new ArrayList<String>();
	    access.add("Technicient qualite");
	    access.add("Responsable qualite");
	    access.add("Injenieur qualite");
	    Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
	    
	    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
	    	return "denied";
	    }
		List<Poste> postes = zoneService.fetchAllPostes() ;
		map.addAttribute("postes",postes);
		Map m = new HashMap();
		Piece p = pieceService.find(ref);
		List<PosteForPiece> pis = new ArrayList<>();
		for (PosteForPiece pi : p.getPosteForPieces()) {
			pis.add(pi);
		}
		m.put("ref", ref);
		m.put("posts", pis);
		map.addAttribute("model",m);
		map.addAttribute("projetWrapper",new ProjetWrapper());
		map.addAttribute("utilisateur",u);
		return "projet/show";
	}
	
	
	@RequestMapping(value="projets/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("projetWrapper")ProjetWrapper projetWrapper,@RequestParam("ref")String ref,HttpServletRequest request) throws IOException
	{
		List<MultipartFile> files = projetWrapper.getImages();
		
		if(files.get(0).getOriginalFilename().equals("")) {
			Piece p = pieceService.find(projetWrapper.getRef());
			p.setPosteForPieces(new ArrayList<PosteForPiece>());
			for (String title : projetWrapper.getPosts()) {
				PosteForPiece  posteForPiece = new PosteForPiece();
				posteForPiece.setPiece(p);
				posteForPiece.setTitle(title);
				zoneService.addPosteForPiece(posteForPiece);
				p.getPosteForPieces().add(posteForPiece);
			}
			pieceService.update(p);
		}else {
			for (MultipartFile multipartFile : files) {
				Piece p = pieceService.find(projetWrapper.getRef());
				p.setImages(new ArrayList<Picture>());
				pieceService.update(p);
				Picture picture = new Picture();
				picture.setPicture(multipartFile.getBytes());
		        picture.setPiece(p);
				p.getImages().add(picture);
				pieceService.update(p);
				List<PosteForPiece> posteForPieces = p.getPosteForPieces();
				p.setPosteForPieces(new ArrayList<PosteForPiece>());
				for (String title : projetWrapper.getPosts()) {
					PosteForPiece  posteForPiece = new PosteForPiece();
					posteForPiece.setPiece(p);
					posteForPiece.setTitle(title);
					zoneService.addPosteForPiece(posteForPiece);
					p.getPosteForPieces().add(posteForPiece);
				}
				pieceService.update(p);
			}
		}
        return "redirect:"+request.getHeader("Referer");
	}
	
	
	

}
