package com.service;



import org.springframework.stereotype.Service;

import com.model.UtilisateurRole;

@Service
public interface UtilisateurRoleService {
	
	public void addUtilisateurRole(UtilisateurRole utilisateurRole);
	public UtilisateurRole getUtilisateurRoleById(long id);

}
