package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.index.UtilisateurIndex;
import com.model.Utilisateur;
import com.model.UtilisateurRole;

@Service
public interface UtilisateurService {
	
	public void addUtilisateur(Utilisateur u);
	public Utilisateur getUtilisateurById(Long id);
	public List<Utilisateur> getUtilisateurByRole(UtilisateurRole utilisateurRole);
	public List<Utilisateur> fetchAll();
	public void delete(Long id);
	public Utilisateur getUtilisateurByUsername(String name);
	public void update(Utilisateur utilisateur);

}
