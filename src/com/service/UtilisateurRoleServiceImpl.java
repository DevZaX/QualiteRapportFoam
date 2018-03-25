package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UtilisateurDAO;
import com.dao.UtilisateurRoleDAO;
import com.model.UtilisateurRole;

public class UtilisateurRoleServiceImpl implements UtilisateurRoleService {

	
private UtilisateurRoleDAO utilisateurRoleDAO;

	
	
	@Autowired
	public void setUtilisateurRoleDAO(UtilisateurRoleDAO utilisateurRoleDAO) {
		this.utilisateurRoleDAO = utilisateurRoleDAO;
	}


	
	@Override
	@Transactional
	public void addUtilisateurRole(UtilisateurRole utilisateurRole) {
		utilisateurRoleDAO.addUtilisateurRole(utilisateurRole);
		
	}



	@Override
	@Transactional
	public UtilisateurRole getUtilisateurRoleById(long id) {
		return utilisateurRoleDAO.getUtilisateurRoleById(id);
	}

}
