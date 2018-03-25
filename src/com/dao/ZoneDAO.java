package com.dao;

import java.util.List;

import com.model.Zone;

public interface ZoneDAO {
	
	public void addZone(Zone zone);
	
	public List<Zone> listZone();
	
	public Zone getZoneById(long id);
	
	public Zone getZoneByTitle(String title);
	
	public void deleteZone(long id);
	
	

}
