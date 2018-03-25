package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DefautReceptionDAO;
import com.model.DefautReception;

@Service
public class DefautReceptionServiceImpl implements DefautReceptionService {
	
	private DefautReceptionDAO defautReceptionDAO;
	
	
    
    @Autowired
	public void setDefautReceptionDAO(DefautReceptionDAO defautReceptionDAO) {
		this.defautReceptionDAO = defautReceptionDAO;
	}

	@Override
	@Transactional
	public void save(DefautReception defautReception) {
		
		defautReceptionDAO.save(defautReception);
		
	}

	@Override
	@Transactional
	public void delete(DefautReception defautReception) {
		
		defautReceptionDAO.delete(defautReception);
		
	}

	@Override
	@Transactional
	public List<DefautReception> fetchAll() {
		
		return defautReceptionDAO.fetchAll();
	}

	@Override
	@Transactional
	public DefautReception findByCode(String code) {
		return defautReceptionDAO.findByCode(code);
	}

	@Override
	@Transactional
	public DefautReception findByTitle(String defaut) {
		return defautReceptionDAO.findByTitle(defaut);
	}

}
