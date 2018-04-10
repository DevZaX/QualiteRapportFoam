package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DefautDAO;
import com.model.Defaut;


@Service
public class DefautServiceImpl implements DefautService{
	
	private DefautDAO defautDAO;
	
	
	
    @Autowired
	public void setDefautDAO(DefautDAO defautDAO) {
		this.defautDAO = defautDAO;
	}




	@Override
	@Transactional
	public void addDefaut(Defaut defaut) {
		
		defautDAO.addDefaut(defaut);	}




	@Override
	@Transactional
	public Defaut getDefautByCode(String code) {
		return defautDAO.getDefautByCode(code);
	}







	@Override
	@Transactional
	public void removeDefaut(String code) {
		defautDAO.removeDefaut(code);
		
	}




	@Override
	@Transactional
	public Defaut getDefautByTitle(String title) {
		return defautDAO.getDefautByTitle(title);
	}




	@Override
	@Transactional
	public List<Defaut> listDefaut() {
		return defautDAO.listDefaut();
	}




	@Override
	@Transactional
	public List<Defaut> findBySide(String string) {
		
		return defautDAO.findBySide(string);
	}

}
