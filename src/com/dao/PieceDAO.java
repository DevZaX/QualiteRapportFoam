package com.dao;

import java.util.List;

import com.model.Piece;

public interface PieceDAO {
	
 public void addPiece(Piece piece);

public Piece find(String ref);

public List<Piece> fetchAll();

public void update(Piece piece);

}
