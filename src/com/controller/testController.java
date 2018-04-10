package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.index.ControlInjectionIndex;
import com.model.ControlInjection;
import com.model.DefautControl;
import com.service.ControlInjectionService;
import com.service.PieceService;

@Controller
public class testController {
	
	private static final Logger logger = LoggerFactory.getLogger(testController.class);
	
	private ControlInjectionService controlInjectionService;
	private PieceService pieceService;
	
	@Autowired
	@Qualifier(value="pieceService")
	 public void setPieceService(PieceService pieceService) {
		this.pieceService = pieceService;
	}

	@Autowired
		@Qualifier(value="controlInjectionService")
		public void setControlInjectionService(ControlInjectionService controlInjectionService) {
			this.controlInjectionService = controlInjectionService;
		}
	
	@RequestMapping(value="topdefect",method=RequestMethod.GET)
	public String topDefect()
	{
		List<DefautControl> defautControlItemsRetouche = new ArrayList<>();
		List<DefautControl> defautControlItemsScrap = new ArrayList<>();
		
		Date startDate = new Date();
		Date endDate = new Date();
		
		List<ControlInjection> cc = controlInjectionService.fetchAll(startDate, endDate);
		for (ControlInjection controlInjection : cc) {
			List<DefautControl> defautControls = controlInjection.getDefauts();
			
			for (DefautControl defautControl : defautControls) {
				if(defautControl.getType().equals("Retouche")) {
					int index = getIndex(defautControl,defautControlItemsRetouche);
					if(index == -1)
					{
						defautControlItemsRetouche.add(defautControl);
					}else {
						defautControlItemsRetouche.get(index).setQte(defautControl.getQte()+defautControlItemsRetouche.get(index).getQte());
					}
				}
				if(defautControl.getType().equals("Scrap")) {
					int index = getIndex(defautControl,defautControlItemsScrap);
					if(index == -1)
					{
						defautControlItemsScrap.add(defautControl);
					}else {
						defautControlItemsScrap.get(index).setQte(defautControl.getQte()+defautControlItemsScrap.get(index).getQte());
					}
				}
				
				
			}
		}
		
//		Collections.sort(defautControlItemsRetouche);
//		Collections.sort(defautControlItemsScrap);
		
		System.err.println("Retouche");
	for (DefautControl x : defautControlItemsRetouche) {
		System.err.println(x.getCode()+":"+x.getQte());
	}
	
	System.err.println("Scrap");
	for (DefautControl x : defautControlItemsScrap) {
		System.err.println(x.getCode()+":"+x.getQte());
	}
		
		return "";
	}
	
	public int getIndex(DefautControl defaut,List<DefautControl> list) {
		for(int i=0;i<list.size();i++)
		{
			if(defaut.getCode().equals(list.get(i).getCode())) {
				return i;
			}
		}
		return -1;
	}

	
	
	
}

