package com.dao;

import java.util.List;

import com.model.Alert;
import com.model.ControlReception;

public interface AlertDAO {
	
	public void save(Alert alert);

	public ControlReception getControlReception(Long id);

	public Alert find(Long num);

	public void update(Alert alert);

	public List<Alert> fetchAll();

	public void delete(Long num);

	public List<Alert> fetchAllOpen();

}
