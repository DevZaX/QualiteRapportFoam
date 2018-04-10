package com.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.AlertInjection;
import com.model.ControlInjection;
import com.model.ControlMur;
import com.model.Defaut;
import com.model.DefautControl;
import com.model.DefautControlMur;
import com.model.Piece;
import com.model.Poste;
import com.model.PosteForPiece;
import com.model.Projet;
import com.model.Zone;
import com.service.AlertInjectionService;
import com.service.ControlInjectionService;
import com.service.ControlMurService;
import com.service.DefautControlMurService;
import com.service.DefautControlService;
import com.service.DefautService;
import com.service.PieceService;
import com.service.ZoneService;

@Controller
public class ControlMurController {
	

	private ControlMurService controlMurService;
	private DefautService defautService;
	private PieceService pieceService;
	private ZoneService zoneService;
	private AlertInjectionService alertInjectionService;
	private DefautControlMurService defautControlMurService;

	
	@Autowired
	public void setAlertInjectionService(AlertInjectionService alertInjectionService) {
		this.alertInjectionService = alertInjectionService;
	}
	
	
	
	@Autowired
	@Qualifier(value="zoneService")
	public void setZoneService(ZoneService zoneService) {
		this.zoneService = zoneService;
	}


	@Autowired
	@Qualifier(value="pieceService")
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}

	
	
	
	@Autowired
	@Qualifier(value="defautControlMurService")
	public void setDefautControlMurService(DefautControlMurService defautControlMurService) {
		this.defautControlMurService = defautControlMurService;
	}


    @Autowired
    @Qualifier(value="defautService")
	public void setDefautService(DefautService defautService) {
		this.defautService = defautService;
	}




    @Autowired
	@Qualifier(value="controlMurService")
	public void setControlInjectionService(ControlMurService controlMurService) {
		this.controlMurService = controlMurService;
	}
	
	
	
	@RequestMapping(value="test/2",method=RequestMethod.GET)
	public String test(ModelMap map)
	{
		String[] shifts = {"matin","Apres midi","nuit"};
	    List<String> zones = new ArrayList<>();
	    for (Zone zone : zoneService.listZone()) {
			zones.add(zone.getTitle());
		}
	    List<String> postes = new ArrayList<>();
	    for (Poste poste : zoneService.fetchAllPostes()) {
	    	postes.add(poste.getTitle());
		}
	    String[] prototypes = {"serie" ,"nouveau projet"};
	    String[] equipes = {"A","B","C"};
	    map.addAttribute("shifts",shifts);
	    map.addAttribute("zones",zones);
	    map.addAttribute("postes",postes);
	    map.addAttribute("prototypes",prototypes);
	    map.addAttribute("equipes",equipes);
		return "exemple/controle_mur_authentification";
	}
	
	 @RequestMapping(value="controle_mur/auth",method=RequestMethod.POST)
	 public String controle_injection_auth(ModelMap map,
			 @RequestParam("mat")String mat,
			 @RequestParam("mat_c")String mat_e,
			 @RequestParam("shift")String shift,
			 @RequestParam("equipe")String equipe,
			 @RequestParam("zone")String zone,
			 @RequestParam("prototype")String prototype,
			 @RequestParam("poste")String poste,
			 HttpServletRequest request) {
		 request.getSession().setAttribute("mat", mat);
		 request.getSession().setAttribute("mat_c", mat_e);
		 request.getSession().setAttribute("shift", shift);
		 request.getSession().setAttribute("equipe", equipe);
		 request.getSession().setAttribute("zone", zone);
		 request.getSession().setAttribute("prototype", prototype);
		 request.getSession().setAttribute("poste", poste);
		 request.getSession().setAttribute("date",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		
		 return "redirect:/controle_mur/work";
	 }
	 
	 
	 @RequestMapping(value="controle_mur/work",method=RequestMethod.GET)
	 public String controle_injection_auth(HttpServletRequest request) {
		 if(request.getSession().getAttribute("mat") == null) {
			 return "redirect:../test/2";
		 }
		 return "exemple/d2";
	 }
	 
	 
	 @RequestMapping(value="controle_mur/get",method=RequestMethod.POST)
		public String fun1(@RequestParam("ref")String ref,
				RedirectAttributes redirectAttributes,
				HttpServletRequest request) throws UnsupportedEncodingException
		{
			 Date startDate = new Date();
		     Date endDate = new Date();
			 ControlMur controlMur = controlMurService.fetchAll(startDate,endDate,ref.toUpperCase());
			 if(controlMur != null) {
				 redirectAttributes.addFlashAttribute("ref",controlMur.getRef());
				 
			 }else {
				 redirectAttributes.addFlashAttribute("ref",ref);
				 redirectAttributes.addFlashAttribute("picture",null);
			 }
			 Piece piece = pieceService.find(ref);
			 if(piece != null) {
				 String poste_name = (String) request.getSession().getAttribute("poste");
				 List<String> poste_names = new ArrayList<>();
				 for (PosteForPiece pst : piece.getPosteForPieces()) {
					poste_names.add(pst.getTitle());
				}
				 if(poste_names.contains(poste_name))
				 {
					 Projet projet = piece.getFamille().getProjet();
					 redirectAttributes.addFlashAttribute("projet_title",projet.getTitle());
					 byte[] encodeBase64 = Base64.encodeBase64(piece.getImages().get(0).getPicture());
					 redirectAttributes.addFlashAttribute("picture",new String(encodeBase64, "UTF-8")); 
					 AlertInjection alertInjection = alertInjectionService.findByProjet(projet.getId());
					 if(alertInjection != null) {
						 redirectAttributes.addFlashAttribute("alert",alertInjection); 
						 String alert_picture = new String(Base64.encodeBase64(alertInjection.getPicture()),"UTF-8");
						 redirectAttributes.addFlashAttribute("alert_picture",alert_picture); 
						 redirectAttributes.addFlashAttribute("produit",projet.getTitle()); 
					 }
				 }
				
		         
			 }
			 
			 List<Defaut> defautsRight1 = defautService.findBySide("right-1");
			 List<Defaut> defautsRight2 = defautService.findBySide("right-2");
			 List<Defaut> defautsLeft1 = defautService.findBySide("left-1");
			 List<Defaut> defautsLeft2 = defautService.findBySide("left-2");
			 List<Defaut> defautsTop = defautService.findBySide("top");
			 List<Defaut> defautsBottom= defautService.findBySide("bottom");
			 redirectAttributes.addFlashAttribute("defautsRight1",defautsRight1);
			 redirectAttributes.addFlashAttribute("defautsRight2",defautsRight2);
			 redirectAttributes.addFlashAttribute("defautsLeft1",defautsLeft1);
			 redirectAttributes.addFlashAttribute("defautsLeft2",defautsLeft2);
			 redirectAttributes.addFlashAttribute("defautsTop",defautsTop);
			 redirectAttributes.addFlashAttribute("defautsBottom",defautsBottom);

			return "redirect:/controle_mur/work";
		}
	 
	 
	    @RequestMapping(value="controle_mur/store",method=RequestMethod.POST)
		@ResponseBody
		public String store(@RequestParam("ref")String ref,
				@RequestParam("code")String code,
				@RequestParam("type")String type,
				@RequestParam("equipe")String equipe,
				@RequestParam("matricule")String matricule,
				@RequestParam("prototype")String prototype,
				@RequestParam("matriculeC")String matriculeC,
				@RequestParam("shift")String shift,
				@RequestParam("zone")String zone,
				RedirectAttributes redirectAttributes)
		{
			Date startDate = new Date();
			Date endDate = new Date();
			ControlMur cc = controlMurService.fetchAll(startDate, endDate, ref);
			if(cc == null) {
				 ControlMur c = new ControlMur();
				 c.setDate(new Date());
				 c.setEquipe(equipe);
				 c.setMatricule(matricule);
				 c.setPrototype(prototype);
				 c.setMatricule_controlleur_injection(matriculeC);
				 c.setShift(shift);
				 c.setZone(zone);
				 c.setRef(ref);
				 controlMurService.addControlMur(c);
				 DefautControlMur dc = defautControlMurService.getDefautControlMurByControlIdAndTypeAndCode(c.getId(),type,code);
				 if(dc != null) {
					 dc.setQte(dc.getQte()+1);
					 defautControlMurService.update(dc);
				 }else {
					 
					 DefautControlMur defautControlMur = new DefautControlMur();
					 defautControlMur.setCode(code);
					 defautControlMur.setType(type);
					 defautControlMur.setControlMur(c);
					 defautControlMur.setQte(1);
					 c.getDefautControlMurs().add(defautControlMur);
					 defautControlMurService.addDefautControl(defautControlMur);
				 }
				 
			}else {
				 DefautControlMur dc = defautControlMurService.getDefautControlMurByControlIdAndTypeAndCode(cc.getId(),type,code);
				 if(dc != null) {
					 dc.setQte(dc.getQte()+1);
					 defautControlMurService.update(dc);
				 }else {
					 
					 DefautControlMur defautControlMur = new DefautControlMur();
					 defautControlMur.setCode(code);
					 defautControlMur.setType(type);
					 defautControlMur.setControlMur(cc);
					 defautControlMur.setQte(1);
					 cc.getDefautControlMurs().add(defautControlMur);
					 defautControlMurService.addDefautControl(defautControlMur);
				 }
			}
			
			return "good";
		}

}
