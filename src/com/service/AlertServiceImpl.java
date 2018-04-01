package com.service;

import java.util.List;

import javax.persistence.Temporal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AlertDAO;
import com.model.Alert;
import com.model.ControlReception;

@Service
public class AlertServiceImpl implements AlertService {
	
	private AlertDAO alertDAO;
	
	
    @Autowired
	public void setAlertDAO(AlertDAO alertDAO) {
		this.alertDAO = alertDAO;
	}



	@Override
	@Transactional
	public void save(Alert alert) {
		alertDAO.save(alert);
	}



	@Override
	@Transactional
	public ControlReception getControlReception(Long id) {
		
		return alertDAO.getControlReception(id);
	}



	@Override
	@Transactional
	public Alert find(Long num) {
		
		return alertDAO.find(num);
	}



	@Override
	@Transactional
	public void update(Alert alert) {
	   alertDAO.update(alert);
	}



	@Override
	@Transactional
	public List<Alert> fetchAll() {
		
		return alertDAO.fetchAll();
	}



	@Override
	@Transactional
	public void delete(Long num) {
		alertDAO.delete(num);
		
	}



	@Override
	@Transactional
	public List<Alert> fetchAllOpen() {
		return alertDAO.fetchAllOpen();
	}

}
