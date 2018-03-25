package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.DefautReception;

@Repository
public class DefautReceptionDAOImpl implements DefautReceptionDAO{
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(DefautReception defautReception) {
		 Session session = sessionFactory.getCurrentSession();
		 session.save(defautReception);
		
	}

	@Override
	public void delete(DefautReception defautReception) {
		 Session session = sessionFactory.getCurrentSession();
		 session.delete(defautReception);
		
	}

	@Override
	public List<DefautReception> fetchAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DefautReception").list();
	}

	@Override
	public DefautReception findByCode(String code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DefautReception where code = :code");
		query.setParameter("code", code);
		DefautReception defautReception = (DefautReception) query.uniqueResult();
		return defautReception;
	}

	@Override
	public DefautReception findByTitle(String defaut) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from DefautReception where title = :defaut");
		query.setParameter("defaut", defaut);
		DefautReception defautReception = (DefautReception) query.uniqueResult();
		return defautReception;
	}

}
