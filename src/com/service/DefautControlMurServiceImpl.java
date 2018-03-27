package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DefautControlDAO;
import com.dao.DefautControlMurDAO;
import com.index.DefautInjectionIndex;
import com.model.Defaut;
import com.model.DefautControl;
import com.model.DefautControlMur;

public class DefautControlMurServiceImpl implements DefautControlMurService {
	
	
	private DefautControlMurDAO defautControlDAO;
	
	
	@Autowired
	public void setDefautControlMurDAO(DefautControlMurDAO defautControlDAO) {
		this.defautControlDAO = defautControlDAO;
	}




	@Override
	@Transactional
	public void addDefautControl(DefautControlMur defautControl) {
		
		defautControlDAO.addDefautControl(defautControl);
	}




	@Override
	@Transactional
	public List<Object> getQteAndCodeByType(Long id, String type) {
		return defautControlDAO.getQteAndCodeByType(id, type);
	}




	



	@Override
	@Transactional
	public void update(DefautControlMur dc) {
		
		defautControlDAO.update(dc);
		
	}




	@Override
	@Transactional
	public DefautControlMur getDefautControlByControlIdAndTypeAndCode(Long id, String type,String code) {
		return defautControlDAO.getDefautControlByControlIdAndTypeAndCode(id, type,code);
	}

}
