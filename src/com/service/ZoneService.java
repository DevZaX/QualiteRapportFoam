package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Poste;
import com.model.PosteForPiece;
import com.model.Zone;

@Service
public interface ZoneService {
	
	public void addZone(Zone zone);
	
    public List<Zone> listZone();
	
	public Zone getZoneById(long id);
	
	public Zone getZoneByTitle(String title);
	
	public void deleteZone(long id);

	public void addPoste(Poste poste);

	public List<Poste> fetchAllPostes();

	public void deletePoste(Long id);

	public void addPosteForPiece(PosteForPiece posteForPiece);

	public void deletePosteForPiece(PosteForPiece posteForPiece);

	public PosteForPiece findPosteForPieceByTitle(String poste_name);
	
	PosteForPiece findPosteForPieceById(Long id);

}
