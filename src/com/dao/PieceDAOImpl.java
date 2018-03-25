package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model.Piece;

@Repository
public class PieceDAOImpl implements PieceDAO{
	
private SessionFactory sessionFactory;
	
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void addPiece(Piece piece) {
		Session session = sessionFactory.getCurrentSession();
		session.save(piece);
		
	}


	@Override
	public Piece find(String ref) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Piece where ref = :ref");
		query.setParameter("ref", ref);
		return (Piece) query.uniqueResult();
	}


	@Override
	public List<Piece> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Piece> pieces = session.createQuery("from Piece").list();
		return pieces;
	}


	@Override
	public void update(Piece piece) {
		Session session = sessionFactory.getCurrentSession();
		session.update(piece);
		
	}

}
