package com.dao;


import java.util.Date;
import java.util.List;

import com.model.ControlInjection;
import com.model.ControlMur;

public interface ControlMurDAO {
	
	public void addControlMur(ControlMur controlMur);

	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase,String mat);

	public List<ControlMur> filter(Date start, Date end, String zone, String prototype, String equipe);

	public int getInt(String requete);

}
