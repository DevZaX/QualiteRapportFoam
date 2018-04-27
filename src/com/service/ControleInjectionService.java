package com.service;

import java.util.Date;
import java.util.List;

import com.model.ControleInjection;



public interface ControleInjectionService {
	
	public void save(ControleInjection c);
	
	public ControleInjection getByDateAndRefAndMatAndTypeAndCode(Date start,Date end,String ref,String mat,String type,String code);
	
	public void update(ControleInjection c);
	
	public List<Object> execute(String r);
	
	public int getInt(String requete);

	public int getQteByProjet(Date date_debut, Date date_fin, String string, String title);

	public double getQteByFamille(Date date_debut, Date date_fin, String string, String title);

	public double getQteByVersion(Date date_debut, Date date_fin, String string, String version);
	
	public List<Object> getDefautsBy(Date date_debut,
			Date date_fin,
			String zone,
			String shift,
			String equipe,
			String projet,
			String famille,
			String version,
			String prototype, String type_value); 
	
	public List<Object> getQteAndProjectsByDefaut(Date date_debut,Date date_fin,String defaut);
	public List<Object> execute(Date date_debut, Date date_fin, String string);
	public int getQteByTypeAndRef(Date date1,Date date2,String type,String ref);
	public List<ControleInjection> getControlesInjectionByRef(Date date1,Date date2,String ref);
	public List<ControleInjection> getControlesInjection(Date date1,Date date2);
	public int getQteByType(Date date1,Date date2,String type);

	public List<ControleInjection> filter(Date start, Date end, String zone, String prototype, String equipe);

	public List<String> filterRef(Date start, Date end, String zone, String prototype, String equipe);
	
	public ControleInjection getControleInjectionById(Long id);
	
	public int getQteByDateAndRefAndMatAndType(Date start,Date end,String ref,String mat,String type);

}
