package com.dao;

import java.util.Date;
import java.util.List;

import com.model.ControlInjection;

public interface ControlInjectionDAO {
	
	public void addControlInjection(ControlInjection controlInjection);

	public List<ControlInjection> fetchAll(Date startDate, Date endDate);

	public void delete(Long id);

	public ControlInjection fetchAll(Date startDate, Date endDate, String ref);

	public ControlInjection findByRef(String string);

	public List<ControlInjection> findBy(Date startDate, Date endDate,String champ, String type);

}
