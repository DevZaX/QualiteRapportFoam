package com.dao;

import java.util.List;

import com.index.UtilisateurIndex;
import com.model.Utilisateur;
import com.model.UtilisateurRole;

public interface UtilisateurDAO {
	
	public void addUtilisateur(Utilisateur u);
	public Utilisateur getUtilisateurById(Long id);
	public List<Utilisateur> getUtilisateurByRole(UtilisateurRole utilisateurRole);
	public List<Utilisateur> fetchAll();
	public void delete(Long id);
	public Utilisateur getUtilisateurByUsername(String name);
	public void update(Utilisateur utilisateur);

}
