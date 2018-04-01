package com.service;

import java.util.List;

import com.model.Zone40F;

public interface Zone40FService {
	
	public void save(Zone40F zone40F);
	
    public void update(Zone40F zone40F);
	
	public void delete(Long id);

	public List<Zone40F> fetchAll();

	public Zone40F find(Long id);

}
