package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Piece;
import com.model.Projet;



public interface ProjetService {
	
	public void saveOrUpdateProjet(Projet projet);

	public Projet getProjetById(Long id);
	
	public List<Projet> getProjets();
	
	public Projet getProjetByTitle(String title);

	public List<Projet> fetchAll();

	public void delete(Long id);

	

}
