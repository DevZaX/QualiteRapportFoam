package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;
import com.model.DefautControlMur;


@Repository
public interface DefautControlMurDAO {
	
	public void addDefautControl(DefautControlMur defautControl);

	public List<Object> getQteAndCodeByType(Long id, String type);
	
	public DefautControlMur getDefautControlByControlIdAndTypeAndCode(Long id,String type,String code);

	public void update(DefautControlMur dc);

}
