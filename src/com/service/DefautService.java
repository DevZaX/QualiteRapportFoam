package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Defaut;

@Service
public interface DefautService {
	
	public void addDefaut(Defaut defaut);
	
    public Defaut getDefautByCode(String code);
	
	public void removeDefaut(String code);
	
	public Defaut getDefautByTitle(String title);
	
	public List<Defaut> listDefaut();

	

}
