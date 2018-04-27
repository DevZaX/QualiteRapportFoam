package com.service;

import java.util.Date;
import java.util.List;

import com.model.ControleMur;



public interface ControleMurService {
	
	public void save(ControleMur c);
	
	public ControleMur getByDateAndRefAndMatAndTypeAndCode(Date start,Date end,String ref,String mat,String type,String code);
	
	public void update(ControleMur c);
	
	public List<Object> execute(String r);
	
	public int getInt(String requete);

	public int getQteByProjet(Date date_debut, Date date_fin, String string, String title);

	public double getQteByFamille(Date date_debut, Date date_fin, String string, String title);

	public double getQteByVersion(Date date_debut, Date date_fin, String string, String version);

	public double getQteByTypeAndRef(Date start, Date end, String string, String s);

	public double getQteByType(Date start, Date end, String string);

	public List<String> filterRef(Date start, Date end, String prototype, String equipe);

	public List<ControleMur> getControlesMurByRef(Date date_debut, Date date_fin, String ref);

	public ControleMur getControleMurById(Long id);

}
