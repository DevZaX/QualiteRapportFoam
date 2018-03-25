package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.EmballageDAO;
import com.model.Emballage;

@Service
public class EmballageServiceImpl implements EmballageService{
	
	private EmballageDAO emballageDAO;
	
	
    @Autowired
	public void setEmballageDAO(EmballageDAO emballageDAO) {
		this.emballageDAO = emballageDAO;
	}



	@Override
	@Transactional
	public void save(Emballage emballage) {
		
		emballageDAO.save(emballage);
	}

}
