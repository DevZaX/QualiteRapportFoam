package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DefautControlDAO;
import com.index.DefautInjectionIndex;
import com.model.Defaut;
import com.model.DefautControl;

public class DefautControlServiceImpl implements DefautControlService {
	
	
	private DefautControlDAO defautControlDAO;
	
	
	@Autowired
	public void setDefautControlDAO(DefautControlDAO defautControlDAO) {
		this.defautControlDAO = defautControlDAO;
	}




	@Override
	@Transactional
	public void addDefautControl(DefautControl defautControl) {
		
		defautControlDAO.addDefautControl(defautControl);
	}




	@Override
	@Transactional
	public List<Object> getQteAndCodeByType(Long id, String type) {
		return defautControlDAO.getQteAndCodeByType(id, type);
	}

}
