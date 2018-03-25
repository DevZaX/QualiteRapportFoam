package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.DefautControlReception;

@Repository
public class DefautControlReceptionDAOImpl implements DefautControlReceptionDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(DefautControlReception defautControlReception) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(defautControlReception);
	}



	@Override
	public DefautControlReception find(Long id) {
		Session session = sessionFactory.getCurrentSession();
		DefautControlReception defautControlReception = (DefautControlReception) session.load(DefautControlReception.class, new Long(id));
		return defautControlReception;
	}



	@Override
	public void delete(Long id) {
		Session session = sessionFactory.getCurrentSession();
		DefautControlReception defautControlReception = find(id);
		if(defautControlReception != null)
		{
		session.delete(defautControlReception);
		}
		
	}

}
