package com.dao;

import com.model.UtilisateurRole;

public interface UtilisateurRoleDAO {
	
	public void addUtilisateurRole(UtilisateurRole utilisateurRole);
	
	public UtilisateurRole getUtilisateurRoleById(long id);

}
