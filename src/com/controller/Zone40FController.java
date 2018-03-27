package com.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Zone40F;
import com.service.AlertService;
import com.service.Zone40FService;

@Controller
public class Zone40FController {
	
	private Zone40FService zone40FService;
	
	private AlertService alertService;
	
	
	
	
    @Autowired
    @Qualifier(value="zone40FService")
	public void setZone40FService(Zone40FService zone40fService) {
		zone40FService = zone40fService;
	}

    @Autowired
    @Qualifier(value="alertService")
	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}

	@RequestMapping(value="zone40f/{id_alert}/show",method=RequestMethod.GET)
	public String index(@PathVariable("id_alert")Long id_alert,
			ModelMap map)
	{
		map.addAttribute("id_alert",id_alert);
		return "zone40f/index";
	}
	
	@RequestMapping(value="zone40f/store",method=RequestMethod.POST)
	public String store(@RequestParam("id_alert")Long id_alert,
			@RequestParam("qte")int qte,
			@RequestParam("id_mgz")String id_mgz,
			@RequestParam("emplacement")String emplacement)
	{
		Zone40F zone40f = new Zone40F();
		zone40f.setAlert(alertService.find(id_alert));
		zone40f.setDate_mouvement(new Date());
		zone40f.setDate_sortie(null);
		zone40f.setEmplacement(emplacement);
		zone40f.setId_mgz(id_mgz);
		zone40f.setQte(qte);
		zone40FService.save(zone40f);
		return "redirect:index";
	}
	
	

}
