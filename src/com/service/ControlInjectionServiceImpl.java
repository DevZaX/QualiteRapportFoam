package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ControlInjectionDAO;
import com.model.ControlInjection;
import com.model.DefautControl;

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
	public ControlInjection fetchAll(Date startDate, Date endDate, String ref,String matricule) {
		return controlDAO.fetchAll(startDate,endDate,ref,matricule);
	}



	@Override
	@Transactional
	public ControlInjection findByRef(String string) {
		return controlDAO.findByRef(string);
	}



	@Override
	@Transactional
	public List<ControlInjection> findBy(Date startDate, Date endDate,String champ ,String type) {
		
		return controlDAO.findBy(startDate,endDate,champ,type);
	}



	@Override
	@Transactional
	public List<ControlInjection> filter(Date date_debut, Date date_fin, String zone, String prototype,
			String equipe) {
		return controlDAO.filter(date_debut,date_fin,zone,prototype,equipe);
	}



	@Override
	@Transactional
	public ControlInjection find(Long id) {
		return controlDAO.find(id);
	}



	@Override
	@Transactional
	public List<ControlInjection> critere(Date date_debut, Date date_fin, String zone, String prototype, String equipe,
			String projet, String famille, String designation) {
		
		return controlDAO.critere(date_debut, date_fin, zone, prototype, equipe, projet, famille, designation);
	}

}
