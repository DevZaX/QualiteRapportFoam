package com.dao;

import java.util.List;

import com.model.Projet;

public interface ProjetDAO {
	
	public void saveOrUpdateProjet(Projet projet);

	public Projet getProjetById(Long id);
	
	public List<Projet> getProjets();
	
	public Projet getProjetByTitle(String title);

	public List<Projet> fetchAll();

	public void delete(Long id);
}
