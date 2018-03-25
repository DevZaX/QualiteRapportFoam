package com.service;

import java.util.List;

import com.model.Fournisseur;

public interface FournisseurService {
	
	public void save(Fournisseur fournisseur);
	public void delete(Long id);
	public Fournisseur find(Long id);
	public List<Fournisseur> fetchAll();


}
