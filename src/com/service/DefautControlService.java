package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;

@Service
public interface DefautControlService {

	public void addDefautControl(DefautControl defautControl);
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @return list of defaults groubed by code content code and quantite
	 */
	public List<Object> getQteAndCodeByType(Long id,String type);
	
	public DefautControl getDefautControlByControlIdAndTypeAndCode(Long id,String type,String code);

	public void update(DefautControl dc);
	
	public List<DefautControl> fetchAll();
	
	public DefautControl find(Long id);

}
