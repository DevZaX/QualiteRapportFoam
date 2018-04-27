package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ZoneDAO;
import com.model.Poste;
import com.model.PosteForPiece;
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




	@Override
	@Transactional
	public void addPoste(Poste poste) {
		zoneDAO.addPoste(poste);
		
	}




	@Override
	@Transactional
	public List<Poste> fetchAllPostes() {
		return zoneDAO.fetchAllPostes();
	}




	@Override
	@Transactional
	public void deletePoste(Long id) {
		zoneDAO.deletePoste(id);
		
	}




	@Override
	@Transactional
	public void addPosteForPiece(PosteForPiece posteForPiece) {
		zoneDAO.addPosteForPiece(posteForPiece);
		
	}




	@Override
	@Transactional
	public void deletePosteForPiece(PosteForPiece posteForPiece) {
		zoneDAO.deletePosteForPiece(posteForPiece);
		
	}




	@Override
	@Transactional
	public PosteForPiece findPosteForPieceByTitle(String poste_name) {
		return zoneDAO.findPosteForPieceByTitle(poste_name);
	}




	@Override
	@Transactional
	public PosteForPiece findPosteForPieceById(Long id) {
		return zoneDAO.findPosteForPieceById(id);
	}

}
