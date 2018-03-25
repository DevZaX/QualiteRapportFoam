package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ZoneDAO;
import com.model.Zone;


@Service
public class ZoneServiceImpl implements ZoneService {
	
	private ZoneDAO zoneDAO;
	
	
	
    @Autowired
	public void setZoneDAO(ZoneDAO zoneDAO) {
		this.zoneDAO = zoneDAO;
	}




	@Override
	@Transactional
	public void addZone(Zone zone) {
		zoneDAO.addZone(zone);
	}




	@Override
	@Transactional
	public List<Zone> listZone() {
		return zoneDAO.listZone();
	}




	@Override
	@Transactional
	public Zone getZoneById(long id) {
		return zoneDAO.getZoneById(id);
	}




	@Override
	@Transactional
	public Zone getZoneByTitle(String title) {
		return zoneDAO.getZoneByTitle(title);
	}




	@Override
	@Transactional
	public void deleteZone(long id) {
		zoneDAO.deleteZone(id);
		
	}

}
