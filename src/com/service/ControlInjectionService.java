package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.ControlInjection;

@Service
public interface ControlInjectionService {
	
	public void addControlInjection(ControlInjection controlInjection);

	public List<ControlInjection> fetchAll(Date startDate, Date endDate);

	public void delete(Long id);

	public ControlInjection fetchAll(Date startDate, Date endDate, String ref);

	public ControlInjection findByRef(String string);

}
