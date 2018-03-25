package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.index.DefautInjectionIndex;
import com.model.DefautControl;


@Repository
public interface DefautControlDAO {
	
	public void addDefautControl(DefautControl defautControl);

	public List<Object> getQteAndCodeByType(Long id, String type);

}
