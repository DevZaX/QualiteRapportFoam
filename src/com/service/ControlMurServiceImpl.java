package com.service;

import java.util.Date;
import java.util.List;

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
	public ControlMur fetchAll(Date startDate, Date endDate, String upperCase,String mat) {
		return controlDAO.fetchAll(startDate,endDate,upperCase,mat);
	}



	@Override
	@Transactional
	public List<ControlMur> filter(Date start, Date end, String zone, String prototype, String equipe) {
		return controlDAO.filter(start,end,zone,prototype,equipe);
	}



	@Override
	public int getInt(String requete) {
		return controlDAO.getInt(requete);
	}

}
