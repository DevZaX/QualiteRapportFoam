package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ControlInjectionDAO;
import com.model.ControlInjection;

public class ControlInjectionServiceImpl implements ControlInjectionService {
	
	private ControlInjectionDAO controlDAO;
	
	
    @Autowired
	public void setControlInjectionDAO(ControlInjectionDAO controlDAO) {
		this.controlDAO = controlDAO;
	}



	@Override
	@Transactional
	public void addControlInjection(ControlInjection controlInjection) {
		controlDAO.addControlInjection(controlInjection);
	}



	@Override
	@Transactional
	public List<ControlInjection> fetchAll(Date startDate, Date endDate) {
		return controlDAO.fetchAll(startDate,endDate);
	}



	@Override
	@Transactional
	public void delete(Long id) {
		controlDAO.delete(id);
		
	}



	@Override
	@Transactional
	public ControlInjection fetchAll(Date startDate, Date endDate, String ref) {
		return controlDAO.fetchAll(startDate,endDate,ref);
	}



	@Override
	@Transactional
	public ControlInjection findByRef(String string) {
		return controlDAO.findByRef(string);
	}

}
