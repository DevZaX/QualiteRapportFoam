package com.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.model.AlertInjection;
import com.model.Piece;
import com.model.Projet;
import com.service.AlertInjectionService;
import com.service.PieceService;
import com.service.ProjetService;
import com.service.UtilisateurService;
import com.wrapper.AlertInjectionWrapper;

@Controller
public class AlertInjectionController {
       
	private AlertInjectionService alertInjectionService;
	private PieceService pieceService;
	private UtilisateurService utilisateurService;
	private ProjetService projetService;

	@Autowired
	public void setProjetService(ProjetService projetService) {
		this.projetService = projetService;
	}
	@Autowired
	public void setAlertInjectionService(AlertInjectionService alertInjectionService) {
		this.alertInjectionService = alertInjectionService;
	}
	@Autowired
	public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}
	@Autowired
	public void setUtilisateurService(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@RequestMapping(value="alert_injection/index",method=RequestMethod.GET)
	public String index(ModelMap map)
	{
		List<AlertInjection> alertInjections = alertInjectionService.fetchAll();
		map.addAttribute("alertInjections",alertInjections);
		return "alert_injection/index";
	}
	
	@RequestMapping(value="alert_injection/create",method=RequestMethod.GET)
	public String create(ModelMap map)
	{	
		map.addAttribute("projets",projetService.fetchAll());
		map.addAttribute("alertInjectionWrapper",new AlertInjectionWrapper());
		return "alert_injection/create";
	}
	
	@RequestMapping(value="alert_injection/store",method=RequestMethod.POST)
	public String store(ModelMap map,
			@ModelAttribute("alertInjectionWrapper")AlertInjectionWrapper alertInjectionWrapper,
			RedirectAttributes redirectAttributes) throws ParseException, IOException
	{	
		
		List<String> msgs = new ArrayList<>();
		
		
		for (Long id : alertInjectionWrapper.getId()) {
			AlertInjection t = alertInjectionService.findByProjet(id);
			if(t== null) {
				AlertInjection alertInjection = new AlertInjection();
				alertInjection.setDate_alert((new SimpleDateFormat("yyyy-mm-dd").parse(alertInjectionWrapper.getDate_alert())));
				alertInjection.setDate_fin_alert((new SimpleDateFormat("yyyy-mm-dd").parse(alertInjectionWrapper.getDate_fin_alert())));
				alertInjection.setClient(alertInjectionWrapper.getClient());
				alertInjection.setDefaut(alertInjectionWrapper.getDefaut());
				alertInjection.setMsg(alertInjectionWrapper.getMsg());
				alertInjection.setNbr_pieces(alertInjectionWrapper.getNbr_pieces());
				alertInjection.setPicture(alertInjectionWrapper.getImage().getBytes());
				alertInjection.setProjet_id(id);
				alertInjectionService.save(alertInjection);
			}else {
				msgs.add("projet with id :"+id+"already have an alert!");
			}
			
		}
		redirectAttributes.addFlashAttribute("msgs",msgs);
		
		return "redirect:index";
	}
	
	@RequestMapping(value="alert_injection/{alert_injection_id}/show",method=RequestMethod.GET)
	public String show(ModelMap map,@PathVariable("alert_injection_id") Long alert_injection_id) throws UnsupportedEncodingException {
		
		AlertInjection alert = alertInjectionService.find(alert_injection_id);
		map.addAttribute("alert",alert);
		map.addAttribute("alert_picture",new String(Base64.encodeBase64(alert.getPicture()),"UTF-8"));
		return "alert_injection/show";
	}
	
	
	
	
	@RequestMapping(value="alert_injection/{alert_injection_id}/edit",method=RequestMethod.GET)
	public String edit(ModelMap map,@PathVariable("alert_injection_id") Long alert_injection_id){
		
		AlertInjection alert = alertInjectionService.find(alert_injection_id);
		AlertInjectionWrapper alertInjectionWrapper = new AlertInjectionWrapper();
	    alertInjectionWrapper.setClient(alert.getClient());
		alertInjectionWrapper.setDate_alert(new SimpleDateFormat("yyyy-MM-dd").format(alert.getDate_alert()));
		alertInjectionWrapper.setDate_fin_alert(new SimpleDateFormat("yyyy-MM-dd").format(alert.getDate_fin_alert()));
		alertInjectionWrapper.setDefaut(alert.getDefaut());
		alertInjectionWrapper.setMsg(alert.getMsg());
		alertInjectionWrapper.setNbr_pieces(alert.getNbr_pieces());
		
		map.addAttribute("alertInjectionWrapper",alertInjectionWrapper);
		map.addAttribute("id",alert_injection_id);
		
		
		return "alert_injection/edit";
	}
	
	@RequestMapping(value="alert_injection/{alert_injection_id}/delete",method=RequestMethod.GET)
	public String delete(ModelMap map,@PathVariable("alert_injection_id") Long alert_injection_id,
			HttpServletRequest request){
		
		alertInjectionService.delete(alertInjectionService.find(alert_injection_id));
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="alert_injection/update",method=RequestMethod.POST)
	public String update(@ModelAttribute("alertInjectionWrapper")AlertInjectionWrapper alertInjectionWrapper,
			@RequestParam("id")Long id,
			HttpServletRequest request) throws ParseException{
		
		AlertInjection alertInjection = alertInjectionService.find(id);
		
		alertInjection.setClient(alertInjectionWrapper.getClient());
		alertInjection.setDate_alert(new SimpleDateFormat("yyyy-mm-dd").parse(alertInjectionWrapper.getDate_alert()));
		alertInjection.setDate_fin_alert(new SimpleDateFormat("yyyy-mm-dd").parse(alertInjectionWrapper.getDate_fin_alert()));
		alertInjection.setDefaut(alertInjectionWrapper.getDefaut());
		alertInjection.setMsg(alertInjectionWrapper.getMsg());
		alertInjection.setNbr_pieces(alertInjectionWrapper.getNbr_pieces());
		
		alertInjectionService.update(alertInjection);

		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="alert_injection/{id}/edit_picture",method=RequestMethod.GET)
	public String edit_picture(@PathVariable("id")Long id,ModelMap map) throws UnsupportedEncodingException{
		
		
		map.addAttribute("alert_picture",new String(Base64.encodeBase64(alertInjectionService.find(id).getPicture()),"UTF-8"));
		map.addAttribute("id",id);
		map.addAttribute("alertInjectionWrapper",new AlertInjectionWrapper());
		

		return "alert_injection/edit_picture";
	}
	
	
	
	@RequestMapping(value="alert_injection/update_picture",method=RequestMethod.POST)
	public String update_picture(@RequestParam("id")Long id,
			@ModelAttribute("alertInjectionWrapper")AlertInjectionWrapper alertInjectionWrapper,
			HttpServletRequest request) throws IOException {
		AlertInjection alert = alertInjectionService.find(id);
		alert.setPicture(alertInjectionWrapper.getImage().getBytes());
		alertInjectionService.update(alert);
		return "redirect:"+request.getHeader("Referer");
	}
	
	
	
	

}
