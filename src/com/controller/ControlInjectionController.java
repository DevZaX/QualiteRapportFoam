package com.controller;


import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

import com.google.gson.Gson;
import com.index.ControlInjectionIndex;
import com.index.DefautInjectionIndex;
import com.model.AlertInjection;
import com.model.ControlInjection;
import com.model.ControleInjection;
import com.model.Defaut;
import com.model.DefautControl;
import com.model.Famille;
import com.model.Piece;
import com.model.Poste;
import com.model.PosteForPiece;
import com.model.Projet;
import com.model.Utilisateur;
import com.model.Zone;
import com.service.AlertInjectionService;
import com.service.ControlInjectionService;
import com.service.ControleInjectionService;
import com.service.DefautControlService;
import com.service.DefautService;
import com.service.FamilleService;
import com.service.PieceService;
import com.service.ProjetService;
import com.service.UtilisateurService;
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
	private ProjetService projetService;
	private FamilleService familleService;
	private ControleInjectionService controleInjectionService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	public void setUtilisateurService(UtilisateurService us){
		utilisateurService = us;
	}
	
	
	@Autowired
	public void setControleInjectionService(ControleInjectionService controleInjectionService) {
		this.controleInjectionService = controleInjectionService;
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
	
	
	
	


	
	
	
	@RequestMapping(value="controle_injection/ready",method=RequestMethod.GET)
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
		 Piece piece = pieceService.find(ref);
		// System.err.println(piece.getPosteForPieces().get(0).getTitle());
		 if(piece != null) {
			 String poste_name = (String) request.getSession().getAttribute("poste");
			 List<String> poste_names = new ArrayList<>();
			 for (PosteForPiece pst : piece.getPosteForPieces()) {
				poste_names.add(pst.getTitle());
			}
			 if(poste_names.contains(poste_name))
			 {
				 String mat = (String) request.getSession().getAttribute("mat");
				 Projet projet = piece.getFamille().getProjet();
				 redirectAttributes.addFlashAttribute("projet_title",projet.getTitle());
				 byte[] encodeBase64 = Base64.encodeBase64(piece.getImages().get(0).getPicture());
				 redirectAttributes.addFlashAttribute("picture",new String(encodeBase64, "UTF-8"));
				 redirectAttributes.addFlashAttribute("ref",ref); 
				 AlertInjection alertInjection = alertInjectionService.findByProjet(projet.getId());
				 if(alertInjection != null) {
					 redirectAttributes.addFlashAttribute("alert",alertInjection); 
					 String alert_picture = new String(Base64.encodeBase64(alertInjection.getPicture()),"UTF-8");
					 redirectAttributes.addFlashAttribute("alert_picture",alert_picture); 
					 redirectAttributes.addFlashAttribute("ok",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='ok' and matricule='"+mat+"' and ref='"+ref+"'"));
					 redirectAttributes.addFlashAttribute("scrap",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='scrap' and matricule='"+mat+"' and ref='"+ref+"'"));
					 redirectAttributes.addFlashAttribute("retouche1",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='retouche1' and matricule='"+mat+"' and ref='"+ref+"'"));
					 redirectAttributes.addFlashAttribute("retouche2",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='retouche2' and matricule='"+mat+"' and ref='"+ref+"'"));
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
			RedirectAttributes redirectAttributes,
			HttpServletRequest request)
	{
		Date startDate = new Date();
		Date endDate = new Date();
		ControleInjection cc = controleInjectionService.getByDateAndRefAndMatAndTypeAndCode(startDate, endDate, ref, matricule, type, code);
		if(cc == null) {
			 ControleInjection c = new ControleInjection();
			 c.setDate(new Date());
			 c.setEquipe(equipe);
			 c.setMatricule(matricule);
			 c.setPrototype(prototype);
			 c.setMatriculeEmballeur(matriculeE);
			 c.setShift(shift);
			 c.setZone(zone);
			 c.setRef(ref);
			 c.setFamille(pieceService.find(ref).getFamille().getTitle());
			 c.setProjet(pieceService.find(ref).getFamille().getProjet().getTitle());
			 c.setVersion(pieceService.find(ref).getVersion());
			 c.setCode(code);
			 c.setPrototype(pieceService.find(ref).getPrototype());
			 c.setQte(1);
			 c.setType(type);
			 controleInjectionService.save(c);
		}else {
			cc.setQte(cc.getQte()+1);
			controleInjectionService.update(cc);
		}
		Map map = new HashMap();
		String mat = (String) request.getSession().getAttribute("mat");
		map.put("ok",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='ok' and matricule='"+mat+"' and ref='"+ref+"'"));
		map.put("scrap",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='scrap' and matricule='"+mat+"' and ref='"+ref+"'"));
		map.put("retouche1",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='retouche1' and matricule='"+mat+"' and ref='"+ref+"'"));
		map.put("retouche2",controleInjectionService.getInt("select sum(qte) from ControleInjection where date between :date1 and :date2 and type='retouche2' and matricule='"+mat+"' and ref='"+ref+"'"));
		return new Gson().toJson(map);
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
			 return "redirect:../controle_injection/ready";
		 }
		 return "control_injection/work";
	 }
	 
	 
	   
	    
	 	 
		
		
		
      
        
        
        @RequestMapping(value="controle_injection/generale",method=RequestMethod.GET)
        public String generale(ModelMap map,Principal p)
        {
        	List<String> access = new ArrayList<String>();
 		    access.add("Technicient qualite");
 		    access.add("Responsable qualite");
 		    access.add("Injenieur qualite");
 		   access.add("Coordinateur injection");
 		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
 		    
 		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
 		    	return "denied";
 		    }
        	List<Zone> zones = zoneService.listZone();
        	map.addAttribute("zones",zones);
        	map.addAttribute("date",new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        	map.addAttribute("utilisateur",u);
         	return "control_injection/generale";
        }
        
        
        @RequestMapping(value="controle_injection/filter",method=RequestMethod.POST)
        public String filter(ModelMap map,
        		@RequestParam("date_debut")String date_debut,
        		@RequestParam("date_fin")String date_fin,
        		@RequestParam("zone")String zone,
        		@RequestParam("prototype")String prototype,
        		@RequestParam("equipe")String equipe,
        		RedirectAttributes attributes) throws ParseException
        {
        	
        	Date start = new SimpleDateFormat("yyyy-MM-dd").parse(date_debut);
        	Date end = new SimpleDateFormat("yyyy-MM-dd").parse(date_fin);
        	List<String> refs = controleInjectionService.filterRef(start,end,zone,prototype,equipe);
        	List<Map> controles = new ArrayList<>();
        	for (String s : refs) {
				Map controle = new HashMap();
				double ok = controleInjectionService.getQteByTypeAndRef(start, end,"ok", s);
				double scrap = controleInjectionService.getQteByTypeAndRef(start, end,"scrap", s);
				double retouche1 = controleInjectionService.getQteByTypeAndRef(start, end,"retouche1",s);
				double retouche2 = controleInjectionService.getQteByTypeAndRef(start, end,"retouche2", s);
				double piece_price = pieceService.find(s).getPrice();
				double famille_price = pieceService.find(s).getFamille().getPrice();
				double famille_weight = pieceService.find(s).getFamille().getWeight();
				controle.put("ref", s);
				controle.put("famille", s);
				controle.put("projet", s);
				controle.put("ok", new DecimalFormat("0").format(ok));
				controle.put("scrap",new DecimalFormat("0").format(scrap));
				controle.put("retouche1", new DecimalFormat("0").format(retouche1));
				controle.put("retouche2",new DecimalFormat("0").format(retouche2));
				controle.put("controller",new DecimalFormat("0").format(ok+scrap));
				controle.put("RFT",new DecimalFormat("0").format(ok-(retouche1+retouche2)));
				controle.put("scrap_rate",new DecimalFormat("0.00").format(scrap/(scrap+ok)));
				controle.put("IPPM",new DecimalFormat("0.00").format(scrap/(scrap+ok)*1000000));
				controle.put("scrap_cost",new DecimalFormat("0.00").format(scrap*piece_price));
				controle.put("totale_cost",new DecimalFormat("0.00").format((ok+scrap)*piece_price));
				controle.put("product_weight_scrap",new DecimalFormat("0.00").format(scrap*famille_weight));
				controle.put("product_weight_totale",new DecimalFormat("0.00").format((ok+scrap)*famille_weight));
				controle.put("product_price_scrap",new DecimalFormat("0.00").format((ok+scrap)*famille_price));
				controle.put("product_price_totale",new DecimalFormat("0.00").format((ok+scrap)*famille_price));
				controles.add(controle);
				
			}
        	double ok = controleInjectionService.getQteByType(start, end, "ok");
        	double scrap = controleInjectionService.getQteByType(start, end, "scrap");
        	double retouche1 = controleInjectionService.getQteByType(start, end, "retouche1");
        	double retouche2 = controleInjectionService.getQteByType(start, end, "retouche2");
        	System.err.print(controles.size());
        	attributes.addFlashAttribute("controles",controles);
        	attributes.addFlashAttribute("scrap_global_injection",new DecimalFormat("0.00").format(scrap/(ok+scrap)));
        	attributes.addFlashAttribute("IPPM_global_injection",new DecimalFormat("0.00").format(scrap/(ok+scrap)*1000000));
        	attributes.addFlashAttribute("RFT_global_injection",new DecimalFormat("0.00").format(ok-(retouche1+retouche2)));
        	attributes.addFlashAttribute("date1",date_debut);
        	attributes.addFlashAttribute("date2",date_fin);
        	attributes.addFlashAttribute("zone",zone);
        	attributes.addFlashAttribute("equipe",equipe);
        	attributes.addFlashAttribute("prototype",prototype);
        
         	return "redirect:generale";
        }
        
        @RequestMapping(value="controle_injection/defects",method=RequestMethod.GET)
        public String defefts(ModelMap map)
        {
        	List<Zone> zones = zoneService.listZone();
        	List<Projet> projets = projetService.fetchAll();
        	List<Famille> familles = familleService.fetchAll();
        	List<Piece> pieces = pieceService.fetchAll();
        	map.addAttribute("zones",zones);
        	map.addAttribute("projets",projets);
        	map.addAttribute("familles",familles);
        	return "control_injection/defects";
        }
        
        @RequestMapping(value="controle_injection/{ref}/{date1}/{date2}/info",method=RequestMethod.GET)
        public String detaille(@PathVariable("ref")String ref,
        		@PathVariable("date1")String start,
        		@PathVariable("date2")String end,
        		RedirectAttributes attributes,
        		Principal p) throws ParseException {
        	List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    access.add("Coordinateur injection");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
        	Date date_debut = new SimpleDateFormat("yyyy-MM-dd").parse(start);
        	Date date_fin = new SimpleDateFormat("yyyy-MM-dd").parse(end);
        	List<ControleInjection> controleInjections = controleInjectionService.getControlesInjectionByRef(date_debut,date_fin, ref);
        	attributes.addFlashAttribute("model",controleInjections);
        	attributes.addFlashAttribute("ref",ref);
        	attributes.addFlashAttribute("date_debut",start);
        	attributes.addFlashAttribute("date_fin",end);
        	System.err.print(controleInjections.size());
        	return "redirect:../../../../controle_injection/detaille";
        }
        
        @RequestMapping(value="controle_injection/detaille",method=RequestMethod.GET)
        public String controle_injection_info_get(Principal p,ModelMap map) {
        	List<String> access = new ArrayList<String>();
		    access.add("Technicient qualite");
		    access.add("Responsable qualite");
		    access.add("Injenieur qualite");
		    access.add("Coordinateur injection");
		    Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		    
		    if(!access.contains(u.getUtilisateurRoles().get(0).getRole())) {
		    	return "denied";
		    }
		    map.addAttribute("utilisateur",u);
        	return "control_injection/info";
        }
        
        @RequestMapping(value="defaut_controle/update",method=RequestMethod.POST)
    	public String update(HttpServletRequest request,@RequestParam("id")Long id,@RequestParam("qte")int qte) {
    		ControleInjection controleInjection = controleInjectionService.getControleInjectionById(id);
    		controleInjection.setQte(qte);
    		controleInjectionService.update(controleInjection);
    		return "control_injection/generale";
    	}
        
        @RequestMapping(value="controle_injection/arreter",method=RequestMethod.GET)
    	public String arreter(HttpServletRequest request) {
    		request.getSession().setAttribute("mat", null);
    		return "redirect:/controle_injection/ready";
    	}
        
        

}
