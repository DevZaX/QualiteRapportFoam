package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.FournisseurDAO;
import com.model.Fournisseur;

@Service
public class FournisseurServiceImpl implements FournisseurService {
	
	private FournisseurDAO fournisseurDAO;
	
	
    @Autowired
	public void setFournisseurDAO(FournisseurDAO fournisseurDAO) {
		this.fournisseurDAO = fournisseurDAO;
	}

	@Override
	@Transactional
	public void save(Fournisseur fournisseur) {
		
		fournisseurDAO.save(fournisseur);
		
	}

	@Override
	@Transactional
	public void delete(Long id) {
		
		fournisseurDAO.delete(id);
		
	}

	@Override
	@Transactional
	public Fournisseur find(Long id) {
		
		return fournisseurDAO.find(id);
	}

	@Override
	@Transactional
	public List<Fournisseur> fetchAll() {
		return fournisseurDAO.fetchAll();
	}

	

	

}
