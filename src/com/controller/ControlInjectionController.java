package com.controller;


import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.index.ControlInjectionIndex;
import com.index.DefautInjectionIndex;
import com.model.AlertInjection;
import com.model.ControlInjection;
import com.model.Defaut;
import com.model.DefautControl;
import com.model.Piece;
import com.model.Poste;
import com.model.PosteForPiece;
import com.model.Projet;
import com.model.Zone;
import com.service.AlertInjectionService;
import com.service.ControlInjectionService;
import com.service.DefautControlService;
import com.service.DefautService;
import com.service.PieceService;
import com.service.ZoneService;
import com.test.DefautInjectionVue;


@Controller
public class ControlInjectionController {
	

	private ControlInjectionService controlInjectionService;
	private DefautService defautService;
	private PieceService pieceService;
	private ZoneService zoneService;
	private AlertInjectionService alertInjectionService;
	private DefautControlService defautControlService;
	
	
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
	@Qualifier(value="defautControlService")
	public void setDefautControlService(DefautControlService defautControlService) {
		this.defautControlService = defautControlService;
	}


    @Autowired
    @Qualifier(value="defautService")
	public void setDefautService(DefautService defautService) {
		this.defautService = defautService;
	}




    @Autowired
	@Qualifier(value="controlInjectionService")
	public void setControlInjectionService(ControlInjectionService controlInjectionService) {
		this.controlInjectionService = controlInjectionService;
	}
	
	
	
	


	
	@RequestMapping(value="controle_injection/{id}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("id")Long id)
	{
		controlInjectionService.delete(id);
		return "redirect:/controle_injection/index";
	}
	
	
	
	
	@RequestMapping(value="test/1",method=RequestMethod.GET)
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
		return "exemple/controle_authentification";
	}
	
	
	
	
	
	@RequestMapping(value="controle_injection/get",method=RequestMethod.POST)
	public String fun1(@RequestParam("ref")String ref,
			RedirectAttributes redirectAttributes,
			HttpServletRequest request) throws UnsupportedEncodingException
	{
		 Date startDate = new Date();
	     Date endDate = new Date();
		 ControlInjection controlInjection = controlInjectionService.fetchAll(startDate,endDate,ref.toUpperCase());
		 if(controlInjection != null) {
			 redirectAttributes.addFlashAttribute("ref",controlInjection.getRef());
			 
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

		return "redirect:/controle_injection/work";
	}
	
	@RequestMapping(value="controle_injection/store",method=RequestMethod.POST)
	@ResponseBody
	public String store(@RequestParam("ref")String ref,
			@RequestParam("code")String code,
			@RequestParam("type")String type,
			@RequestParam("equipe")String equipe,
			@RequestParam("matricule")String matricule,
			@RequestParam("prototype")String prototype,
			@RequestParam("matriculeE")String matriculeE,
			@RequestParam("shift")String shift,
			@RequestParam("zone")String zone,
			RedirectAttributes redirectAttributes)
	{
		Date startDate = new Date();
		Date endDate = new Date();
		ControlInjection cc = controlInjectionService.fetchAll(startDate, endDate, ref);
		if(cc == null) {
			 ControlInjection c = new ControlInjection();
			 c.setDate(new Date());
			 c.setEquipe(equipe);
			 c.setMatricule(matricule);
			 c.setPrototype(prototype);
			 c.setMatriculeE(matriculeE);
			 c.setShift(shift);
			 c.setZone(zone);
			 c.setRef(ref);
			 controlInjectionService.addControlInjection(c);
			 DefautControl dc = defautControlService.getDefautControlByControlIdAndTypeAndCode(c.getId(),type,code);
			 if(dc != null) {
				 dc.setQte(dc.getQte()+1);
				 defautControlService.update(dc);
			 }else {
				 
				 DefautControl defautControl = new DefautControl();
				 defautControl.setCode(code);
				 defautControl.setType(type);
				 defautControl.setControl(c);
				 defautControl.setQte(1);
				 c.getDefauts().add(defautControl);
				 defautControlService.addDefautControl(defautControl);
			 }
			 
		}else {
			 DefautControl dc = defautControlService.getDefautControlByControlIdAndTypeAndCode(cc.getId(),type,code);
			 if(dc != null) {
				 dc.setQte(dc.getQte()+1);
				 defautControlService.update(dc);
			 }else {
				 
				 DefautControl defautControl = new DefautControl();
				 defautControl.setCode(code);
				 defautControl.setType(type);
				 defautControl.setControl(cc);
				 defautControl.setQte(1);
				 cc.getDefauts().add(defautControl);
				 defautControlService.addDefautControl(defautControl);
			 }
		}
		
		return "good";
	}
	
	 @RequestMapping(value="controle_injection/auth",method=RequestMethod.POST)
	 public String controle_injection_auth(ModelMap map,
			 @RequestParam("mat")String mat,
			 @RequestParam("mat_e")String mat_e,
			 @RequestParam("shift")String shift,
			 @RequestParam("equipe")String equipe,
			 @RequestParam("zone")String zone,
			 @RequestParam("prototype")String prototype,
			 @RequestParam("poste")String poste,
			 HttpServletRequest request) {
		 request.getSession().setAttribute("mat", mat);
		 request.getSession().setAttribute("mat_e", mat_e);
		 request.getSession().setAttribute("shift", shift);
		 request.getSession().setAttribute("equipe", equipe);
		 request.getSession().setAttribute("zone", zone);
		 request.getSession().setAttribute("prototype", prototype);
		 request.getSession().setAttribute("poste", poste);
		 request.getSession().setAttribute("date",new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
		
		 return "redirect:/controle_injection/work";
	 }
	 
	 @RequestMapping(value="controle_injection/work",method=RequestMethod.GET)
	 public String controle_injection_auth(HttpServletRequest request) {
		 if(request.getSession().getAttribute("mat") == null) {
			 return "redirect:../test/1";
		 }
		 return "exemple/d";
	 }
	 
	 
	    @RequestMapping(value="controle_injection_info",method=RequestMethod.GET)
		public String controle_injection_info(ModelMap map)
		{
			Date startDate = new Date();
			Date endDate = new Date();
			List<ControlInjectionIndex> controlInjectionIndexs = new ArrayList<>();
			List<ControlInjection> controlInjections = controlInjectionService.fetchAll(startDate, endDate);
			for (ControlInjection controlInjection : controlInjections) {
				
				List<DefautControl> defautControls = controlInjection.getDefauts();
				List counts = getCounts(defautControls);
				ControlInjectionIndex controlInjectionIndex = new ControlInjectionIndex();
				controlInjectionIndex.setRef(controlInjection.getRef());
				controlInjectionIndex.setQteScrap((int)counts.get(0));
				controlInjectionIndex.setQteRetouche1((int)counts.get(1));
				controlInjectionIndex.setQteRetouche2((int)counts.get(2));
				controlInjectionIndex.setQteOK((int)counts.get(3));
				controlInjectionIndex.setQteController((int)counts.get(3)+(int)counts.get(0));
				controlInjectionIndex.setScrapRate((float)((int)counts.get(0)/(((int)counts.get(3)+(int)counts.get(0)))));
				controlInjectionIndex.setIPPM((double)((int)counts.get(0)/((int)counts.get(3)+(int)counts.get(0)))*1000000);
				controlInjectionIndex.setScrapCost((double) (pieceService.find(controlInjection.getRef()).getPrice()*((int)counts.get(0))));
				controlInjectionIndex.setScrapTotalCost((double)(pieceService.find(controlInjection.getRef()).getPrice()*((int)counts.get(3)+(int)counts.get(0))));
				controlInjectionIndex.setPCCostScrap((double)(pieceService.find(controlInjection.getRef()).getFamille().getPrice()*(int)counts.get(0)));
				controlInjectionIndex.setPCCostTotal((double)(pieceService.find(controlInjection.getRef()).getFamille().getPrice()*((int)counts.get(3)+(int)counts.get(0))));
				controlInjectionIndex.setPCWScrap((double)(pieceService.find(controlInjection.getRef()).getFamille().getWeight()*(int)counts.get(0)));
				controlInjectionIndex.setPCWTotal((double)(pieceService.find(controlInjection.getRef()).getFamille().getWeight()*((int)counts.get(3)+(int)counts.get(0))));
				controlInjectionIndexs.add(controlInjectionIndex);
				
			}
			
			
			map.addAttribute("items",controlInjectionIndexs);
			
			return "control_injection/index";
		}
		
		
		public List getCounts(List<DefautControl> l) {
			List counts = new ArrayList<>();
			int scrap = 0;
			int retouche1 = 0 ;
			int retouche2 = 0;
			int ok = 0;
			for (DefautControl x : l) {
				if(x.getType().equals("scrap")) scrap = scrap + x.getQte();
				if(x.getType().equals("retouche1")) retouche1 = retouche1 + x.getQte();
				if(x.getType().equals("retouche2")) retouche2 = retouche2 + x.getQte();
				if(x.getType().equals("ok")) ok = ok + x.getQte();
				
			}
			counts.add(scrap);
			counts.add(retouche1);
			counts.add(retouche2);
			counts.add(ok);
			return counts;
		}
	 

}
