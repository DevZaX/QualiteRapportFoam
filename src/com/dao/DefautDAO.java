package com.dao;

import java.util.List;

import com.model.Defaut;

public interface DefautDAO {
	
	public void addDefaut(Defaut defaut);
	
	public Defaut getDefautByCode(String code);
	
	public void removeDefaut(String code);
	
	public Defaut getDefautByTitle(String title);
	
	public List<Defaut> listDefaut();

	public List<Defaut> findBySide(String string);

}
