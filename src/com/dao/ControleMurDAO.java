package com.dao;

import java.util.Date;
import java.util.List;

import com.model.ControlMur;
import com.model.ControleInjection;
import com.model.ControleMur;

public interface ControleMurDAO {
	
	public void save(ControleMur c);
	
	public ControleMur getByDateAndRefAndMatAndTypeAndCode(Date start,Date end,String ref,String mat,String type,String code);
	
	public void update(ControleMur c);
	
	public List<Object> execute(String r);
	
	public int getInt(String requete);

	public int getQteByProjet(Date date_debut, Date date_fin, String type, String title);

	public double getQteByFamille(Date date_debut, Date date_fin, String type, String title);

	public double getQteByVersion(Date date_debut, Date date_fin, String type, String version);
	
	public int getQteByTypeAndRef(Date date1, Date date2, String type, String ref);

	public int getQteByType(Date date1,Date date2,String type);

	public List<ControleMur> filter(Date start, Date end, String prototype, String equipe);

	public List<String> filterRef(Date start, Date end,String prototype, String equipe);

	public ControleMur getControleMurById(Long id);

	public ControleMur findByRef(String string);


	List<ControleMur> getControlesMurByRef(Date date1, Date date2, String ref);

	List<ControleMur> getControlesMur(Date date1, Date date2);

}
