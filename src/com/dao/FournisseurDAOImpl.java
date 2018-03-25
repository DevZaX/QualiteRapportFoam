package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Fournisseur;

@Repository
public class FournisseurDAOImpl implements FournisseurDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Fournisseur fournisseur) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(fournisseur);
		
	}

	@Override
	public void delete(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		Fournisseur fournisseur = (Fournisseur) session.load(Fournisseur.class, new Long(id));
		session.delete(fournisseur);
		
	}

	@Override
	public Fournisseur find(Long id) {
		
		Session session = sessionFactory.getCurrentSession();
		return (Fournisseur) session.load(Fournisseur.class, new Long("id"));
		
	}

	@Override
	public List<Fournisseur> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Fournisseur").list();
	}

}
