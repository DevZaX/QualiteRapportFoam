package com.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

import com.index.ControleInjectionIndex;
import com.index.DefautInjectionIndex;
import com.model.ControlInjection;
import com.model.Defaut;
import com.model.DefautControl;
import com.model.Piece;
import com.model.Zone;
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

	private DefautControlService defautControlService;
	
	
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
	
	
	
	

	@RequestMapping(value="controle_injection/store",method=RequestMethod.GET)
	public String store(@RequestParam("ref")String ref,
			@RequestParam("qte")int qte,
			@RequestParam("code")String code,
			@RequestParam("type")String type,
			@RequestParam("title")String title) throws ParseException
	{
		Date startDate = new Date();
		Date endDate = new Date();
		ControlInjection cc = controlInjectionService.fetchAll(startDate, endDate, "12");
		
		if(cc != null)
		{
			 DefautControl defautControl = new DefautControl();
			 defautControl.setCode(code);
			 defautControl.setTitle(title);
			 defautControl.setType(type);
			 defautControl.setQte(qte);
			 defautControl.setControl(cc);
			 cc.getDefauts().add(defautControl);
			 defautControlService.addDefautControl(defautControl);
		}else {
			ControlInjection c = new ControlInjection();
			
			 c.setDate(new Date());
			 c.setEquipe("A");
			 c.setMatricule("AAA");
			 c.setPrototype("serie");
			 c.setMatricule("ZAKARIAE");
			 c.setMatriculeE("ZAKARIAEE");
			 c.setShift("matin");
			 c.setZone("TT30");
			 c.setRef("12");
			 
			 
			 
			 controlInjectionService.addControlInjection(c);
			 
			 DefautControl defautControl = new DefautControl();
			 defautControl.setCode(code);
			 defautControl.setTitle(title);
			 defautControl.setType(type);
			 defautControl.setQte(qte);
			 defautControl.setControl(c);
			 c.getDefauts().add(defautControl);
			 defautControlService.addDefautControl(defautControl);
		}
		
		
		 
        
		 
		 
		
		return "redirect:/controle_injection/index";
		
	}
	
	@RequestMapping(value="controle_injection/index",method=RequestMethod.GET)
	public String index(ModelMap modelMap) throws ParseException
	{
		Date startDate = new Date();
		Date endDate = new Date();
		List<ControlInjection> controlInjections = controlInjectionService.fetchAll(startDate,endDate);
		List<ControleInjectionIndex> controleInjectionIndexs = new ArrayList<>();
		for (ControlInjection controlInjection : controlInjections) {
			ControleInjectionIndex controleInjectionIndex = new ControleInjectionIndex();
			controleInjectionIndex.setDate(new SimpleDateFormat("dd-mm-yyyy").format(controlInjection.getDate()));
			controleInjectionIndex.setRef(controlInjection.getRef());
			controleInjectionIndex.setEquipe(controlInjection.getEquipe());
			controleInjectionIndex.setShift(controlInjection.getShift());
			controleInjectionIndex.setZone(controlInjection.getZone());
			controleInjectionIndex.setMatricule(controlInjection.getMatricule());
			controleInjectionIndex.setId(controlInjection.getId());
			controleInjectionIndex.setPrototype(controlInjection.getPrototype());
			Piece p = pieceService.find(controlInjection.getRef());
			controleInjectionIndex.setVersion(p.getVersion());
			controleInjectionIndexs.add(controleInjectionIndex);
			
		}
		modelMap.addAttribute("controleInjectionIndexs",controleInjectionIndexs);
		return "controle_injection/index";
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
	    String[] prototypes = {"serie" ,"nouveau projet"};
	    String[] equipes = {"A","B","C"};
	    map.addAttribute("shifts",shifts);
	    map.addAttribute("zones",zones);
	    map.addAttribute("prototypes",prototypes);
	    map.addAttribute("equipes",equipes);
		return "exemple/controle_authentification";
	}
	
	@RequestMapping(value="test/2",method=RequestMethod.GET)
	public String test2(ModelMap map)
	{
		
	    
		return "exemple/controle_page";
	}
	
	@RequestMapping(value="getControlInjectionByRefAndDate",method=RequestMethod.POST)
	
	public String getControlInjectionByRefAndDate(@RequestParam("ref")String ref,
			RedirectAttributes redirectAttributes)
	{
		List<Defaut> defauts = defautService.listDefaut();
		List<DefautInjectionVue> defautInjectionVues = new ArrayList<>();
		for (Defaut d : defauts) {
			DefautInjectionVue defautInjectionVue = new DefautInjectionVue();
			defautInjectionVue.setCode(d.getCode());
			defautInjectionVue.setQteR(0);
			defautInjectionVue.setQteS(0);
			defautInjectionVue.setTitle(d.getTitle());
			defautInjectionVues.add(defautInjectionVue);
		}
		
        Date startDate = new Date();
     	Date endDate = new Date();
		ControlInjection controlInjection = controlInjectionService.fetchAll(startDate,endDate,ref.toUpperCase());
		
		redirectAttributes.addFlashAttribute("ref",controlInjection.getRef());
		
	
		List<Object> objects1 = defautControlService.getQteAndCodeByType(controlInjection.getId(), "Retouche") ;
		List<Object> objects2 = defautControlService.getQteAndCodeByType(controlInjection.getId(), "Scrap") ;
		
		if(objects1 == null && objects1 == null) {
			redirectAttributes.addFlashAttribute("defautInjectionVues",null);
		}if(objects1 == null && objects2 != null) {
			
			
			
			Iterator it2 = objects2.iterator();
			
			
		
				
			
			
		    
			for (DefautInjectionVue d : defautInjectionVues) {
				while (it2.hasNext()) {
					Object[] object = (Object[]) it2.next();
					if(d.getCode().equals((String)object[1])) {
						d.setQteS((int)object[0]);
					}
							
				}
			}
			

		
			
			redirectAttributes.addFlashAttribute("defautInjectionVues",defautInjectionVues);
		}if(objects1 != null && objects2 == null) {
			
			Iterator it1 = objects1.iterator();

			for (DefautInjectionVue d : defautInjectionVues) {
				while (it1.hasNext()) {
					Object[] object = (Object[]) it1.next();
					if(d.getCode().equals((String)object[1])) {
						d.setQteR((int)object[0]);
					}
					
				}
			}
			

			redirectAttributes.addFlashAttribute("defautInjectionVues",defautInjectionVues);
			
		}if(objects1 != null && objects2 != null) {
			
			
			Iterator it1 = objects1.iterator();
			Iterator it2 = objects2.iterator();
			
			
		
				
			    
			for (DefautInjectionVue d : defautInjectionVues) {
				while (it1.hasNext()) {
					Object[] object = (Object[]) it1.next();
					if(d.getCode().equals((String)object[1])) {
						d.setQteR((int)object[0]);
					}
					
				}
			}
			
		    
			for (DefautInjectionVue d : defautInjectionVues) {
				while (it2.hasNext()) {
					Object[] object = (Object[]) it2.next();
					if(d.getCode().equals((String)object[1])) {
						d.setQteS((int)object[0]);
					}
							
				}
			}
			

		
			
			redirectAttributes.addFlashAttribute("defautInjectionVues",defautInjectionVues);
			
		}
		
	
		
	   
	    
	   
		
		
		
		
		return "redirect:/test/2";
	}

}
