package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.Zone40FDAO;
import com.model.Zone40F;

@Service
public class Zone40FServiceImpl implements Zone40FService {
	
	private Zone40FDAO zone40FDAO;
	
	
    @Autowired
    @Qualifier(value="zone40FDAO")
	public void setZone40FDAO(Zone40FDAO zone40fdao) {
		zone40FDAO = zone40fdao;
	}



	@Override
	@Transactional
	public void save(Zone40F zone40F) {
		
	zone40FDAO.save(zone40F);	
	}



	@Override
	@Transactional
	public void update(Zone40F zone40f) {
		zone40FDAO.update(zone40f);
		
	}



	@Override
	@Transactional
	public void delete(Long id) {
		zone40FDAO.delete(id);
		
	}

}
