package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;
import com.model.DefautControlMur;

@Service
public interface DefautControlMurService {

	public void addDefautControl(DefautControlMur defautControl);
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @return list of defaults groubed by code content code and quantite
	 */
	public List<Object> getQteAndCodeByType(Long id,String type);
	
	public DefautControlMur getDefautControlByControlIdAndTypeAndCode(Long id,String type,String code);

	public void update(DefautControlMur dc);

	public DefautControlMur getDefautControlMurByControlIdAndTypeAndCode(Long id, String type, String code);

}
