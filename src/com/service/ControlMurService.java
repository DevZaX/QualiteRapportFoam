package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.ControlInjection;
import com.model.ControlMur;

@Service
public interface ControlMurService {
	
	public void addControlMur(ControlMur controlMur);

	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase,String mat);

	public List<ControlMur> filter(Date start, Date end, String zone, String prototype, String equipe);
	
	public int getInt(String requete);

}
