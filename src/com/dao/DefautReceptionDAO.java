package com.dao;

import java.util.List;

import com.model.DefautReception;

public interface DefautReceptionDAO {
	
	public void save(DefautReception defautReception);
	public void delete(DefautReception defautReception);
	public List<DefautReception> fetchAll();
	public DefautReception findByCode(String code);
	public DefautReception findByTitle(String defaut);

}
