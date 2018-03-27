package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportGlobalController {
	
	@RequestMapping(value="/test/4",method=RequestMethod.GET)
	public String index()
	{
		return "index/index";
	}

}
