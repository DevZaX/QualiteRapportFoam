package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Zone;

@Service
public interface ZoneService {
	
	public void addZone(Zone zone);
	
    public List<Zone> listZone();
	
	public Zone getZoneById(long id);
	
	public Zone getZoneByTitle(String title);
	
	public void deleteZone(long id);

}
