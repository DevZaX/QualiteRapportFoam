package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.dao.ControleInjectionDAO;
import com.model.ControleInjection;

@Service
public class ControleInjectionServiceImpl implements ControleInjectionService{
	
	private ControleInjectionDAO controleInjectionDAO;

	@Autowired
	public void setControleInjectionDAO(ControleInjectionDAO controleInjectionDAO) {
		this.controleInjectionDAO = controleInjectionDAO;
	}

	@Override
	@Transactional
	public void save(ControleInjection c) {
		controleInjectionDAO.save(c);
		
	}

	@Override
	@Transactional
	public ControleInjection getByDateAndRefAndMatAndTypeAndCode(Date start, Date end, String ref, String mat,
			String type, String code) {
		    return controleInjectionDAO.getByDateAndRefAndMatAndTypeAndCode(start, end, ref, mat, type, code);
	}

	@Override
	@Transactional
	public void update(ControleInjection c) {
		controleInjectionDAO.update(c);
	}

	@Override
	@Transactional
	public List<Object> execute(String r) {
		return controleInjectionDAO.execute(r);
	}

	@Override
	@Transactional
	public int getInt(String requete) {
		
		return controleInjectionDAO.getInt(requete);
	}

	
	@Override
	@Transactional
	public int getQteByProjet(Date date_debut, Date date_fin, String type, String title) {
		return controleInjectionDAO.getQteByProjet(date_debut,date_fin,type,title);
	}

	@Override
	@Transactional
	public double getQteByFamille(Date date_debut, Date date_fin, String type, String title) {
		return controleInjectionDAO.getQteByFamille(date_debut,date_fin,type,title);
	}

	@Override
	@Transactional
	public double getQteByVersion(Date date_debut, Date date_fin, String type, String version) {
		return controleInjectionDAO.getQteByVersion(date_debut,date_fin,type,version);
	}

	@Override
	@Transactional
	public List<Object> getDefautsBy(Date date_debut, Date date_fin, String zone, String shift, String equipe,
			String projet, String famille, String version, String prototype,String type_value) {
		return controleInjectionDAO.getDefautsBy(date_debut,date_fin,zone,shift,equipe,projet,famille,version,prototype,type_value);
	}

	@Override
	@Transactional
	public List<Object> getQteAndProjectsByDefaut(Date date_debut,Date date_fin,String defaut) {
		return controleInjectionDAO.getQteAndProjectsByDefaut(date_debut,date_fin,defaut);
	}

	
	@Override
	@Transactional
	public List<Object> execute(Date date_debut, Date date_fin, String r) {
		return controleInjectionDAO.execute(date_debut,date_fin,r);
	}

	@Override
	@Transactional
	public int getQteByTypeAndRef(Date date1, Date date2, String type, String ref) {
		return controleInjectionDAO.getQteByTypeAndRef(date1,date2,type,ref);
	}

	@Override
	@Transactional
	public List<ControleInjection> getControlesInjectionByRef(Date date1, Date date2, String ref) {
		return controleInjectionDAO.getControlesInjectionByRef(date1,date2,ref);
	}

	@Override
	@Transactional
	public List<ControleInjection> getControlesInjection(Date date1,Date date2) {
	   return controleInjectionDAO.getControlesInjection(date1,date2);
	}

	@Override
	@Transactional
	public int getQteByType(Date date1, Date date2, String type) {
		return controleInjectionDAO.getQteByType(date1,date2,type);
	}

	@Override
	@Transactional
	public List<ControleInjection> filter(Date start, Date end, String zone, String prototype, String equipe) {
		return controleInjectionDAO.filter(start,end,zone,prototype,equipe);
	}

	@Override
	@Transactional
	public List<String> filterRef(Date start, Date end, String zone, String prototype, String equipe) {
		return controleInjectionDAO.filterRef(start,end,zone,prototype,equipe);
	}

	@Override
	@Transactional
	public ControleInjection getControleInjectionById(Long id) {
		return controleInjectionDAO.getControleInjectionById(id);
	}

	@Override
	@Transactional
	public int getQteByDateAndRefAndMatAndType(Date start, Date end, String ref, String mat, String type) {
		return controleInjectionDAO.getQteByDateAndRefAndMatAndType(start, end, ref, mat, type);
	}

}
