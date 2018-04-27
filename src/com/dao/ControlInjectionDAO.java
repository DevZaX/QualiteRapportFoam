package com.dao;

import java.util.Date;
import java.util.List;

import com.model.ControlInjection;
import com.model.DefautControl;

public interface ControlInjectionDAO {
	
	public void addControlInjection(ControlInjection controlInjection);

	public List<ControlInjection> fetchAll(Date startDate, Date endDate);

	public void delete(Long id);

	public ControlInjection fetchAll(Date startDate, Date endDate, String ref,String matricule);

	public ControlInjection findByRef(String string);

	public List<ControlInjection> findBy(Date startDate, Date endDate,String champ, String type);

	public List<ControlInjection> filter(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe);
	
	public List<ControlInjection> critere(Date date_debut,Date date_fin, String zone, String prototype,
			String equipe,String projet,String famille,String designation);


	public ControlInjection find(Long id);

}
