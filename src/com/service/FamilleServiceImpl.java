package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FamilleDAO;
import com.model.Famille;

public class FamilleServiceImpl implements FamilleService {
	
	private FamilleDAO familleDAO;
	
	
    @Autowired
	public void setFamilleDAO(FamilleDAO familleDAO) {
		this.familleDAO = familleDAO;
	}



	@Override
	@Transactional
	public void save(Famille famille) {
		familleDAO.save(famille);
	}
	

	@Override
	@Transactional
	public void update(Famille famille) {
		familleDAO.update(famille);
	}



	@Override
	@Transactional
	public Famille getFamilleByTitle(String title) {
		return familleDAO.getFamilleByTitle(title);
	}



	@Override
	@Transactional
	public List<Famille> fetchAll() {
		return familleDAO.fetchAll();
	}
	
	

}
