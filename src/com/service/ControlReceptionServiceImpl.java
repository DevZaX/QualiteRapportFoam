package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ControlReceptionDAO;
import com.model.Alert;
import com.model.ControlReception;

@Service
public class ControlReceptionServiceImpl implements ControlReceptionService {
	
	private ControlReceptionDAO controlReceptionDAO;
	
	
    @Autowired
	public void setControlReceptionDAO(ControlReceptionDAO controlReceptionDAO) {
		this.controlReceptionDAO = controlReceptionDAO;
	}



	@Override
	@Transactional
	public void save(ControlReception controlReception) {
		
		controlReceptionDAO.save(controlReception);
	}



	@Override
	@Transactional
	public List<ControlReception> fetchAll() {
		return controlReceptionDAO.fetchAll();
	}



	@Override
	@Transactional
	public ControlReception find(Long id) {
		return controlReceptionDAO.find(id);
	}



	@Override
	@Transactional
	public Alert getAlert(Long id) {
		return controlReceptionDAO.getAlert(id);
	}



	@Override
	@Transactional
	public void delete(Long num) {
		controlReceptionDAO.delete(num);
	}

}
