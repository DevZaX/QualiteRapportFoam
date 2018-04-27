package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.ControlInjection;
import com.model.DefautControl;

@Service
public interface ControlInjectionService {
	
	public void addControlInjection(ControlInjection controlInjection);

	public List<ControlInjection> fetchAll(Date startDate, Date endDate);

	public void delete(Long id);

	public ControlInjection fetchAll(Date startDate, Date endDate, String ref,String matricule);

	public ControlInjection findByRef(String string);

	public List<ControlInjection> findBy(Date startDate, Date endDate,String champ, String chose);

	public List<ControlInjection> filter(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe);
	
	public List<ControlInjection> critere(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe,String projet,String famille,String designation);

	public ControlInjection find(Long id);
	
	

}
