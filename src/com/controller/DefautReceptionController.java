package com.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.DefautReception;
import com.service.DefautReceptionService;

@Controller
public class DefautReceptionController {
	
	private DefautReceptionService defautReceptionService;

	@Autowired
	public void setDefautReceptionService(DefautReceptionService defautReceptionService) {
		this.defautReceptionService = defautReceptionService;
	}
	
	@RequestMapping(value="dreception/index",method=RequestMethod.GET)
	public String index(ModelMap map,Principal p) {
		List<DefautReception> items = defautReceptionService.fetchAll();
		map.addAttribute("items", items);
		return "defautReception/index";
	}
	
	@RequestMapping(value="dreception/create",method=RequestMethod.GET)
	public String create(ModelMap map,Principal p) {
		map.addAttribute("defautReception",new DefautReception());
		return "defautReception/create";
	}
	
	@RequestMapping(value="dreception/{code}/delete",method=RequestMethod.GET)
	public String destroy(@PathVariable("code")String code) {
		
		DefautReception defautReception = defautReceptionService.findByCode(code);
		defautReceptionService.delete(defautReception);
		return "redirect:/dreception/index";
	}
	
	
	@RequestMapping(value="dreception/store",method=RequestMethod.POST)
	public String store(@ModelAttribute("defautReception")DefautReception defautReception)
	{
		defautReceptionService.save(defautReception);
		return "redirect:/dreception/index";
	}
	
	

}
