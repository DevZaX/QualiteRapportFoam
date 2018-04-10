package com.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Picture;
import com.model.Piece;

@Service
public interface PieceService {
	
	public void addPiece(Piece piece);
	public Piece find(String ref);
	public List<Piece> fetchAll();
	public void update(Piece piece);
	public void savePicture(Picture picture);
	public void delete(Piece piece);

}
