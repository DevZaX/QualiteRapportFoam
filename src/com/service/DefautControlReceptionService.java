package com.service;

import com.model.DefautControlReception;

public interface DefautControlReceptionService {
	
	public void save(DefautControlReception defautControlReception);
	
	public DefautControlReception find(Long id);

	public void delete(Long id);

	public void update(DefautControlReception defautControlReception);

}
