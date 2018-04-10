package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PieceDAO;
import com.dao.ProjetDAO;
import com.model.Piece;
import com.model.Projet;


@Service
public class ProjetServiceImpl implements ProjetService{
	
	private ProjetDAO projetDAO;
	
	
    @Autowired
    @Qualifier(value="projetDAO")
	public void setProjetDAO(ProjetDAO projetDAO) {
		this.projetDAO = projetDAO;
	}


	@Override
	@Transactional
	public void saveOrUpdateProjet(Projet projet) {
		projetDAO.saveOrUpdateProjet(projet);
		
	}


	@Override
	@Transactional
	public Projet getProjetById(Long id) {
		return projetDAO.getProjetById(id);
		
	}


	@Override
	@Transactional
	public List<Projet> getProjets() {
		return projetDAO.getProjets();
	}


	@Override
	@Transactional
	public Projet getProjetByTitle(String title) {
	    return projetDAO.getProjetByTitle(title);
	}


	@Override
	@Transactional
	public List<Projet> fetchAll() {
		return projetDAO.fetchAll();
		
	}


	@Override
	@Transactional
	public void delete(Long id) {
		projetDAO.delete(id);
		
	}


	



	

}
