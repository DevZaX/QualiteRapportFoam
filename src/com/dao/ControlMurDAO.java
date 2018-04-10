package com.dao;


import java.util.Date;

import com.model.ControlMur;

public interface ControlMurDAO {
	
	public void addControlMur(ControlMur controlMur);

	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase);

}
