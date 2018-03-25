package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UtilisateurDAO;
import com.index.UtilisateurIndex;
import com.model.Utilisateur;
import com.model.UtilisateurRole;


public class UtilisateurServiceImpl implements UtilisateurService {
	
	
	private UtilisateurDAO utilisateurDAO;
	
	
	@Autowired
	public void setUtilisateurDAO(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}



	@Override
	@Transactional
	public void addUtilisateur(Utilisateur u) {
		
		utilisateurDAO.addUtilisateur(u);
		
	}



	@Override
	@Transactional
	public Utilisateur getUtilisateurById(Long id) {
		
		return utilisateurDAO.getUtilisateurById(id);
	}



	@Override
	@Transactional
	public List<Utilisateur> getUtilisateurByRole(UtilisateurRole utilisateurRole) {
		return utilisateurDAO.getUtilisateurByRole(utilisateurRole);
	}



	@Override
	@Transactional
	public List<Utilisateur> fetchAll() {
		return utilisateurDAO.fetchAll();
	}



	@Override
	@Transactional
	public void delete(Long id) {
		utilisateurDAO.delete(id);
	}



	@Override
	@Transactional
	public Utilisateur getUtilisateurByUsername(String name) {
		return utilisateurDAO.getUtilisateurByUsername(name);
	}



	@Override
	@Transactional
	public void update(Utilisateur utilisateur) {
		utilisateurDAO.update(utilisateur);
	}

}
