package com.dao;

import java.util.List;

import com.model.AlertInjection;


public interface AlertInjectionDAO {
	
	public void save(AlertInjection alertInjection);
	public void update(AlertInjection alertInjection);
	public void delete(AlertInjection alertInjection);
	public AlertInjection find(Long id);
	public List<AlertInjection> fetchAll();
	public AlertInjection findByProjet(Long id);
	
	

}
