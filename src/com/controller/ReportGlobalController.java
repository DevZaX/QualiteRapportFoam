package com.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportGlobalController {
	
	@RequestMapping(value="/test/4",method=RequestMethod.GET)
	public String index(ModelMap map)
	{
		String currentDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
		map.addAttribute("currentDate",currentDate);
		return "index/index";
	}

}
