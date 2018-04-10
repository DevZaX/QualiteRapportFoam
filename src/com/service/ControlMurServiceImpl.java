package com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ControlInjectionDAO;
import com.dao.ControlMurDAO;
import com.model.ControlInjection;
import com.model.ControlMur;

public class ControlMurServiceImpl implements ControlMurService {
	
	private ControlMurDAO controlDAO;
	
	
    @Autowired
	public void setControlMurDAO(ControlMurDAO controlDAO) {
		this.controlDAO = controlDAO;
	}



	@Override
	@Transactional
	public void addControlMur(ControlMur controlMur) {
		controlDAO.addControlMur(controlMur);
	}



	@Override
	@Transactional
	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase) {
		return controlDAO.fetchAll(startDate,endDate,upperCase);
	}

}
