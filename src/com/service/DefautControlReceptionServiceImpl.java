package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DefautControlReceptionDAO;
import com.model.DefautControlReception;

@Service
public class DefautControlReceptionServiceImpl implements DefautControlReceptionService {
	
	private DefautControlReceptionDAO defautControlReceptionDAO;
	
	
    @Autowired
	public void setDefautControlReceptionDAO(DefautControlReceptionDAO defautControlReceptionDAO) {
		this.defautControlReceptionDAO = defautControlReceptionDAO;
	}



	@Override
	@Transactional
	public void save(DefautControlReception defautControlReception) {
		
		defautControlReceptionDAO.save(defautControlReception);
	}



	@Override
	@Transactional
	public DefautControlReception find(Long id) {
		return defautControlReceptionDAO.find(id);
	}



	@Override
	@Transactional
	public void delete(Long id) {
		defautControlReceptionDAO.delete(id);
		
	}



	@Override
	@Transactional
	public void update(DefautControlReception defautControlReception) {
		
		defautControlReceptionDAO.update(defautControlReception);
	}

}
