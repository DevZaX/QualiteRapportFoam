package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.PieceDAO;
import com.model.Picture;
import com.model.Piece;

@Service
public class PieceServiceImpl implements PieceService {
	
	private PieceDAO pieceDAO;
	
	
   @Autowired
   @Qualifier(value="pieceDAO")
	public void setPieceDAO(PieceDAO pieceDAO) {
		this.pieceDAO = pieceDAO;
	}



	@Override
	@Transactional
	public void addPiece(Piece piece) {
		
		pieceDAO.addPiece(piece);
	}



	@Override
	@Transactional
	public Piece find(String ref) {
		return pieceDAO.find(ref);
	}



	@Override
	@Transactional
	public List<Piece> fetchAll() {
		return pieceDAO.fetchAll();
	}



	@Override
	@Transactional
	public void update(Piece piece) {
		pieceDAO.update(piece);
		
	}



	@Override
	@Transactional
	public void savePicture(Picture picture) {
		pieceDAO.savePicture(picture);
		
	}




	@Override
	@Transactional
	public void delete(Piece piece) {
		pieceDAO.delete(piece);
		
	}

}
