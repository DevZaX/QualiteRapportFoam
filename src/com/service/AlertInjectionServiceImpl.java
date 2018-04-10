package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AlertInjectionDAO;
import com.model.AlertInjection;



@Service
public class AlertInjectionServiceImpl implements AlertInjectionService {
	
	private AlertInjectionDAO alertInjectionDAO;

	@Autowired
	public void setAlertInjectionDAO(AlertInjectionDAO alertInjectionDAO) {
		this.alertInjectionDAO = alertInjectionDAO;
	}

	@Override
	@Transactional
	public void save(AlertInjection alertInjection) {
		alertInjectionDAO.save(alertInjection);
		
	}

	@Override
	@Transactional
	public void update(AlertInjection alertInjection) {
		
		alertInjectionDAO.update(alertInjection);
	}

	@Override
	@Transactional
	public void delete(AlertInjection alertInjection) {
		alertInjectionDAO.delete(alertInjection);
		
	}

	@Override
	@Transactional
	public AlertInjection find(Long id) {
		return alertInjectionDAO.find(id);
	}

	@Override
	@Transactional
	public List<AlertInjection> fetchAll() {
		return alertInjectionDAO.fetchAll();
	}

	@Override
	@Transactional
	public AlertInjection findByProjet(Long id) {
		return alertInjectionDAO.findByProjet(id);
	}



}
