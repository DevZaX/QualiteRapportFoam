package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Zone40F;

@Repository
public class Zone40FDAOImpl implements Zone40FDAO {
	
	private SessionFactory sessionFactory;
	
	
    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public void save(Zone40F zone40f) {
		Session session = sessionFactory.getCurrentSession();
		session.save(zone40f);
		
	}

}
