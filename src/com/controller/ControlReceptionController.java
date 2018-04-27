package com.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.index.ControlRIndex;
import com.model.Alert;
import com.model.ControlReception;
import com.model.DefautControlReception;
import com.model.DefautReception;
import com.model.Emballage;
import com.model.Empiecement;
import com.model.Utilisateur;
import com.service.AlertService;
import com.service.ControlReceptionService;
import com.service.DefautControlReceptionService;
import com.service.DefautReceptionService;
import com.service.EmballageService;
import com.service.EmpiecementService;
import com.service.UtilisateurService;
import com.wrapper.ControlReceptionWrapper;

@Controller
public class ControlReceptionController {
	
	private ControlReceptionService controlReceptionService;
	private EmpiecementService empiecementService;
	private EmballageService emballageService;
	private DefautReceptionService defautReceptionService;
	private DefautControlReceptionService defautControlReceptionService;
	private AlertService alertService;
	private UtilisateurService utilisateurService;
	
	@Autowired
	@Qualifier(value="utilisateurService")
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@Autowired
	@Qualifier(value="alertService")
    public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}

	@Autowired
	@Qualifier(value="defautControlReceptionService")
	public void setDefautControlReceptionService(DefautControlReceptionService defautControlReceptionService) {
		this.defautControlReceptionService = defautControlReceptionService;
	}

	@Autowired
	@Qualifier(value="defautReceptionService")
	public void setDefautReceptionService(DefautReceptionService defautReceptionService) {
		this.defautReceptionService = defautReceptionService;
	}

	@Autowired
	@Qualifier(value="empiecementService")
	public void setEmpiecementService(EmpiecementService empiecementService) {
		this.empiecementService = empiecementService;
	}

	@Autowired
	@Qualifier(value="controlReceptionService")
	public void setControlReceptionService(ControlReceptionService controlReceptionService) {
		this.controlReceptionService = controlReceptionService;
	}
	
	
	@Autowired
	@Qualifier(value="emballageService")
	public void setEmballageService(EmballageService emballageService) {
		this.emballageService = emballageService;
	}

	@RequestMapping(value="controlR/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("controlReceptionWrapper")ControlReceptionWrapper controlReceptionWrapper,
			BindingResult result,
			Principal p) throws ParseException
	{
		
		
		
		Empiecement empiecement = empiecementService.getEmpiecementByRef(controlReceptionWrapper.getRef());
		
		if(empiecement != null)
		{
			Emballage emballage = new Emballage();
			emballage.setDate_production(new SimpleDateFormat("yyyy-mm-dd").parse(controlReceptionWrapper.getDate_production()));
			emballage.setDate_reception(new SimpleDateFormat("yyyy-mm-dd").parse(controlReceptionWrapper.getDate_reception()));
			emballage.setNumLot(controlReceptionWrapper.getNumLot());
		    emballage.setEmpiecement(empiecement);
		    emballageService.save(emballage);
		    ControlReception controlReception = new ControlReception();
		    controlReception.setDate_creation(new Date());
		    controlReception.setQte_controlled(controlReceptionWrapper.getQte_controlled());
		    controlReception.setQte_nonConfortable(controlReceptionWrapper.getQte_nonConfortable());
		    controlReception.setQte_planned(controlReceptionWrapper.getQte_planned());
		    controlReception.setEmballage(emballage);
		    controlReception.setUsername(p.getName());
		    controlReceptionService.save(controlReception);
		    
		}

		return "redirect:/controlR/index";
	}
	
	
	@RequestMapping(value="controlR/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
	
		Utilisateur u = utilisateurService.getUtilisateurByUsername(p.getName());
		
		
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		
		map.addAttribute("controlReceptionWrapper", new ControlReceptionWrapper());
		
		List<DefautReception> defautReceptions = defautReceptionService.fetchAll();
		
		map.addAttribute("defautReceptions",defautReceptions);
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		map.addAttribute("date_creation",date);
		List<ControlRIndex> controlRIndexs = new ArrayList<>();
		List<ControlReception> controlReceptions = controlReceptionService.fetchAll();
		for (ControlReception controlReception : controlReceptions) {
			ControlRIndex controlRIndex = new ControlRIndex();
			controlRIndex.setNumero_control(controlReception.getId());
			controlRIndex.setRef(controlReception.getEmballage().getEmpiecement().getRef());
			controlRIndex.setNumLot(controlReception.getEmballage().getNumLot());
			controlRIndex.setDate_production(new SimpleDateFormat("dd-MM-yyyy").format(controlReception.getEmballage().getDate_production()));
			controlRIndex.setDate_reception(new SimpleDateFormat("dd-MM-yyyy").format(controlReception.getEmballage().getDate_reception()));
			controlRIndex.setQte_controlled(controlReception.getQte_controlled());
			controlRIndex.setQte_nonOK(controlReception.getQte_nonConfortable());
			controlRIndex.setQte_planned(controlReception.getQte_planned());
			controlRIndex.setUsername(controlReception.getUsername());
			controlRIndex.setVersion(controlReception.getEmballage().getEmpiecement().getVersion());
			controlRIndex.setQte_accepter(controlReception.getQte_controlled()-controlReception.getQte_nonConfortable());
			controlRIndex.setDefautControlReceptions(controlReception.getDefautControlReceptions());
			controlRIndex.setDate_creation(new SimpleDateFormat("dd-MM-yyyy").format(controlReception.getDate_creation()));
			controlRIndex.setFournisseur(controlReception.getEmballage().getEmpiecement().getFournisseur());
			Alert a = controlReceptionService.getAlert(controlReception.getId());
			if(a==null)
			{
			   controlRIndex.setAlert_etat((long) 0);	
			}else {
				controlRIndex.setAlert_etat(a.getNumero());
			}
			
			controlRIndexs.add(controlRIndex);
			
		}
		map.addAttribute("utilisateur",u);
		map.addAttribute("controlRIndexs",controlRIndexs);
		return "controlR/index";
	}
	
	
	
	
	@RequestMapping(value="controlR/{num}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("num")Long num,Principal principal)
	{
		List<String> roles = new ArrayList<>();
		roles.add("Technicient qualite");
		roles.add("Responsable qualite");
		roles.add("Injenieur qualite");
		roles.add("Coordinatrice");
		roles.add("Controlleur reception");
	
		Utilisateur u = utilisateurService.getUtilisateurByUsername(principal.getName());
		
		
		if(!roles.contains(u.getUtilisateurRoles().get(0).getRole()))
		{
			return "denied";
		}
		controlReceptionService.delete(num);
		return "redirect:/controlR/index";
	}

}
