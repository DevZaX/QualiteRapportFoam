package com.dao;

import java.util.List;

import com.model.Phase;

public interface PhaseDAO {
	
	public List<Phase> fetchAll();
	public Phase find(Long id);
	public Phase findByTitle(String title);
	public void update(Phase phase);
	public void save(Phase phase);
	public void delete(Phase phase);

}
