package com.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Alert;
import com.model.ControlReception;
import com.model.Phase;
import com.service.AlertService;
import com.service.ControlReceptionService;
import com.service.PhaseService;
import com.wrapper.AlertWrapper;

@Controller
public class AlertController {
	
	private AlertService alertService;
	private ControlReceptionService controlReceptionService;
	private PhaseService phaseService;

	@Autowired
	@Qualifier(value="phaseService")
	public void setPhaseService(PhaseService phaseService) {
		this.phaseService = phaseService;
	}

	@Autowired
	@Qualifier(value="controlReceptionService")
	public void setControlReceptionService(ControlReceptionService controlReceptionService) {
		this.controlReceptionService = controlReceptionService;
	}

	@Autowired
	@Qualifier(value="alertService")
	public void setAlertService(AlertService alertService) {
		this.alertService = alertService;
	}
	
	@RequestMapping(value="alerts/store",method=RequestMethod.POST)
	public String store(@RequestParam("type")String type,
			@RequestParam("id")Long id) {
		ControlReception controlReception = controlReceptionService.find(id);
		if(controlReception != null)
		{
			Alert alert = new Alert();
			alert.setControlReception(controlReception);
			alert.setDate_creation(new Date());
			alert.setStatus("open");
			alert.setType(type);
			alertService.save(alert);
			
		}
	return  "redirect:/controlR/index";
		
	}
	
	@RequestMapping(value="alerts/{num}/show",method=RequestMethod.GET)

	public String show(@PathVariable("num")Long num,ModelMap map)
	{
		Alert alert = alertService.find(num);
		List<Phase> phases = phaseService.fetchAll();
		map.addAttribute("alert",alert);
		map.addAttribute("phases",phases);
		return "alert/show";
		

	}

	@RequestMapping(value="alerts/{num}/edit",method=RequestMethod.GET)
	public String edit(@PathVariable("num")Long num,ModelMap map)
	{
		Alert alert = alertService.find(num);
		map.addAttribute("alert",alert);
		return "alert/edit";
	}
	
	@RequestMapping(value="alerts/update",method=RequestMethod.POST)
	public String update(@RequestParam("numero")Long numero,
			@RequestParam("phase")String phase,
			@RequestParam("chargeback")Double chargeback,
			@RequestParam("type")String type,
			HttpServletRequest request)
	{
		Alert alert = alertService.find(numero);
		alert.setChargeback(chargeback);
		alert.setPhase(phase);
		alert.setType(type);
		alertService.update(alert);
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	
	@RequestMapping(value="alerts/{num}/close",method=RequestMethod.GET)
	public String close(@PathVariable("num")Long numero,HttpServletRequest request)
	{
		Alert alert = alertService.find(numero);
		alert.setStatus("close");
		alert.setDate_close(new Date());
		alertService.update(alert);
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="alerts/index",method=RequestMethod.GET)
	public String index(ModelMap map)
	{
		List<Alert> dangers = new ArrayList<>();
		
		List<Alert> alertsOpen = alertService.fetchAllOpen();

		List<Phase> phases = phaseService.fetchAll();
		List<String> items = new ArrayList<>();
		items.add("");
		for (Phase phase : phases) {
			items.add(phase.getTitle());
		}
		
		for (Alert alert : alertsOpen) {
			String phase = alert.getPhase();
			if(phase != null) {
				int duree = phaseService.findByTitle(phase).getDuree();
				Calendar cal = Calendar.getInstance();
				cal.setTime(alert.getDate_creation());
				cal.add(Calendar.HOUR,-24*duree);
				Date d = cal.getTime();
				System.err.println(d);
				if(d.before(new Date()))
				{
					dangers.add(alert);
				}
			}
			
			
		}
		map.addAttribute("dangers",dangers);
		map.addAttribute("items",items);
		return "alert/lister";
	}
	
	@RequestMapping(value="alerts/{num}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("num")Long num)
	{
		alertService.delete(num);
		return "redirect:/alerts/index";
	}
	
	public boolean CheckAlert(Alert alert)
	{
		String phase = alert.getPhase();
		int duree = phaseService.findByTitle(phase).getDuree();
		Calendar cal = Calendar.getInstance();
		cal.setTime(alert.getDate_creation());
		cal.add(Calendar.HOUR,-24*duree);
		Date d = cal.getTime();
		System.err.println(d);
		if(d.before(new Date()))
		{
			return true;
		}
		return false;
	}

}
