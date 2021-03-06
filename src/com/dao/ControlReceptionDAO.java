package com.dao;

import java.util.List;

import com.model.Alert;
import com.model.ControlReception;

public interface ControlReceptionDAO {
	
	public void save(ControlReception controlReception);

	public List<ControlReception> fetchAll();

	public ControlReception find(Long id);

	public Alert getAlert(Long id);

	public void delete(Long num);

	public void update(ControlReception controlReception);

}
