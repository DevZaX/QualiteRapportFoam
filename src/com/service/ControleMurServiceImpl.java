package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.ControleMurDAO;
import com.model.ControleMur;

@Service
public class ControleMurServiceImpl implements ControleMurService{
	
	private ControleMurDAO controleMurDAO;

	@Autowired
	public void setControleMurDAO(ControleMurDAO controleMurDAO) {
		this.controleMurDAO = controleMurDAO;
	}

	@Override
	@Transactional
	public void save(ControleMur c) {
		controleMurDAO.save(c);
		
	}

	@Override
	@Transactional
	public ControleMur getByDateAndRefAndMatAndTypeAndCode(Date start, Date end, String ref, String mat,
			String type, String code) {
		    return controleMurDAO.getByDateAndRefAndMatAndTypeAndCode(start, end, ref, mat, type, code);
	}

	@Override
	@Transactional
	public void update(ControleMur c) {
		controleMurDAO.update(c);
	}

	@Override
	@Transactional
	public List<Object> execute(String r) {
		return controleMurDAO.execute(r);
	}

	@Override
	@Transactional
	public int getInt(String requete) {
		
		return controleMurDAO.getInt(requete);
	}

	
	@Override
	@Transactional
	public int getQteByProjet(Date date_debut, Date date_fin, String type, String title) {
		return controleMurDAO.getQteByProjet(date_debut,date_fin,type,title);
	}

	@Override
	@Transactional
	public double getQteByFamille(Date date_debut, Date date_fin, String type, String title) {
		return controleMurDAO.getQteByFamille(date_debut,date_fin,type,title);
	}

	@Override
	@Transactional
	public double getQteByVersion(Date date_debut, Date date_fin, String type, String version) {
		return controleMurDAO.getQteByVersion(date_debut,date_fin,type,version);
	}

	@Override
	@Transactional
	public double getQteByTypeAndRef(Date start, Date end, String string, String s) {
		return controleMurDAO.getQteByTypeAndRef(start,end,string,s);
	}

	@Override
	@Transactional
	public double getQteByType(Date start, Date end, String string) {
		return controleMurDAO.getQteByType(start,end,string);
	}

	@Override
	@Transactional
	public List<String> filterRef(Date start, Date end, String prototype, String equipe) {
		return controleMurDAO.filterRef(start,end,prototype,equipe);
	}

	@Override
	@Transactional
	public List<ControleMur> getControlesMurByRef(Date date_debut, Date date_fin, String ref) {
		return controleMurDAO.getControlesMurByRef(date_debut,date_fin,ref);
	}

	@Override
	@Transactional
	public ControleMur getControleMurById(Long id) {
		return controleMurDAO.getControleMurById(id);
	}

}
