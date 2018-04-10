package com.dao;

import java.util.List;

import com.model.Famille;

public interface FamilleDAO {
	
	public void save(Famille famille);
	public void update(Famille famille);
	public Famille getFamilleByTitle(String title);
	public List<Famille> fetchAll();
	public Famille find(Long id);

}
